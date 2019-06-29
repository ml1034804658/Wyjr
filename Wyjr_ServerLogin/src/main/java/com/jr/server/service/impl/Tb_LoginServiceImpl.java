package com.jr.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.jr.common.config.ProjectConfig;
import com.jr.common.jwt.JwtUtil;
import com.jr.common.util.EncryptionUtil;
import com.jr.common.util.IdGenerator;
import com.jr.common.util.JedisUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import com.jr.server.dao.Tb_UserDao;
import com.jr.server.dao.Tb_UserLogDao;
import com.jr.server.model.LoginToken;
import com.jr.server.service.Tb_LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

/**
 *@Author feri
 *@Date Created in 2019/6/14 14:32
 */
@Service
public class Tb_LoginServiceImpl implements Tb_LoginService {
    @Autowired
    private Tb_UserDao userDao;
    @Autowired
    private Tb_UserLogDao logDao;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private IdGenerator idGenerator;

    //随时都可以登录，但是只允许在线一个（最新的） 10分钟 连续登录失败3次自动锁定账号1小时
    @Override
    public R login(String phone, String pass) {
        R r;
        //先校验当前账号是否被锁定
        if(jedisUtil.exists(ProjectConfig.USERSD+phone)){
            r=R.setERROR("账号锁定中，剩余时间："+(jedisUtil.ttl(ProjectConfig.USERSD+phone)/60));
        }else {
            //1、校验用户名是否存在
            Tb_User user=userDao.selectByPhone(phone);
            if(user!=null){
                //2、校验密码是否正常
                if(Objects.equals(user.getPassword(), EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI,pass))){
                    //登录成功
                    LoginToken loginToken=new LoginToken();
                    loginToken.setPhone(phone);
                    loginToken.setUid(user.getId());
                    loginToken.setId(idGenerator.nextId()+"");
                    //3、生成Token
                    String token=JwtUtil.createJWT(loginToken.getId(),JSON.toJSONString(loginToken));
                    //4、存储到服务器
                    //1、String 类型 user:phone  token
                    jedisUtil.setex(ProjectConfig.TOKENPHONE+phone,1800,token);
                    //2、String  类型 token phone 校验token是否有效
                    jedisUtil.setex(ProjectConfig.TOKENJWT+token,1800,JSON.toJSONString(user));
                    //3、Zset 记录每个手机号下的所有的Token  score:phone   value:令牌
                    //5、将Token
                    logDao.save(user.getId(),"登录成功，令牌生成");
                    r= R.setOK("OK",token);
                }else {
                    logDao.save(user.getId(),"登录失败，密码有误");
                    r= R.setERROR("密码不正确");
                }
            }else {
                logDao.save(user.getId(),"登录失败，账号有误");
                r= R.setERROR("请先注册账号");
            }
            if(r.getCode()!=1){
                String key=ProjectConfig.USERLOGINCOUNT+phone;
                jedisUtil.setex(key+"_"+System.currentTimeMillis(),600,"1");
                Set<String> set=jedisUtil.keys(key+"*");
                if(set.size()==3){
                    logDao.save(user.getId(),"登录失败超过3次，账号被锁定");
                    //将当前账号冻结 1小时
                    jedisUtil.setex(ProjectConfig.USERSD+phone,3600,"10分钟连续失败三次冻结账号");
                    r=R.setERROR("连续多次账号或密码错误，账号被锁定，请1小时之后再来登录");
                }
            }
        }
        return r;
    }

    @Override
    public R checkLogin(String token) {
        //1、校验Token有效性
        if(JwtUtil.checkJWT(token)){
            //反解析 令牌 获取当初登录的手机号
            LoginToken loginToken=JSON.parseObject(JwtUtil.parseJWT(token),LoginToken.class);
            //获取当前手机号的令牌
            String t=jedisUtil.get(ProjectConfig.TOKENPHONE+loginToken.getPhone());
            //比对令牌
            if(Objects.equals(t,token)) {
                return R.setOK("有效", token);
            }else {
                return R.setERROR("已经在其他地方登录了");
            }
        }else {
            return R.setERROR("Token校验失败");
        }
    }

    @Override
    public R exitLogin(String token) {
        //1、校验Token有效性
        if(JwtUtil.checkJWT(token)){
            jedisUtil.del(ProjectConfig.TOKENJWT+token);
            //反解析 令牌 获取当初登录的手机号
            LoginToken loginToken=JSON.parseObject(JwtUtil.parseJWT(token),LoginToken.class);
            //获取当前手机号的令牌
            jedisUtil.del(ProjectConfig.TOKENPHONE+loginToken.getPhone());

            return R.setOK("退出成功",null);
        }else {
            return R.setERROR("Token校验失败");
        }
    }
}