package com.jr.common.message.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jr.common.config.ProjectConfig;
import com.jr.common.message.core.dao.Tb_MessageLogMapper;
import com.jr.common.message.core.dao.Tb_MessageMapper;
import com.jr.common.message.core.dao.Tb_MsgreceiveMapper;
import com.jr.common.message.core.entity.Tb_Message;
import com.jr.common.message.core.entity.Tb_MessageLog;
import com.jr.common.message.core.entity.Tb_Msgreceive;
import com.jr.common.message.core.service.Tb_MessageService;
import com.jr.common.util.CodeUtil;
import com.jr.common.util.JedisUtil;
import com.jr.common.util.SmsUtil;
import com.jr.common.util.TimeUtil;
import com.jr.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Tb_MessageServiceImpl implements Tb_MessageService {
    @Autowired(required = false)
    private Tb_MessageMapper messageMapper;
    @Autowired(required = false)
    private Tb_MessageLogMapper messagelogMapper;
    @Autowired(required = false)
    private Tb_MsgreceiveMapper msgreceiveMapper;
    @Autowired
    private JedisUtil jedisUtil;
    @Override
    @Transactional
    public R sendMsg(Tb_Message message,String ip) {
        int count=0;
        if(message.getType()<4){
            //短信的话 需要校验 一个手机号一分钟只能发1次
            //一个手机号一天只能发20条
            String c=jedisUtil.get(ProjectConfig.SMSPREDAY+message.getReceive());
            if(c!=null && c.matches("[0-9]{1,2}")){
                count=Integer.parseInt(c);
                if(count>=20){
                    return R.setERROR("亲，一个手机号一天只能发送指定数量的短信");
                }
            }
            //一个手机号一分钟只能发送1次
            if(jedisUtil.exists(ProjectConfig.SMSPRELIMIT+message.getReceive())){
                //存在说明1分钟只能发送过短信
                return R.setERROR("一个手机号一分钟只能发送1次短信");
            }
        }
        //检查是否可以发送
        int code = CodeUtil.createNum(6);
        int flag=3;
        String info="";
        boolean isflag=false;
        try {
            //发送信息
            switch (message.getType()){
                case 1://短信验证码
                    if(jedisUtil.exists(ProjectConfig.SMSCODE+message.getReceive())){
                        //上次的验证码还没失效
                        code=Integer.parseInt(jedisUtil.get(ProjectConfig.SMSCODE+message.getReceive()));
                    }else {
                        code = CodeUtil.createNum(6);
                        isflag=true;
                    }
                    info="发送短信验证码："+code;
                    //验证码3分钟有效
                    SmsUtil.mobileQuery(message.getReceive(),code);
                    flag=1;//发送成功
                    //1分钟
                    jedisUtil.setex(ProjectConfig.SMSPRELIMIT+message.getReceive(),60,"短信发送限制");
                    //1天
                    jedisUtil.setex(ProjectConfig.SMSPREDAY+message.getReceive(), TimeUtil.getLastSeconds(),(count+1)+"");
                    if(isflag){
                        //记录验证码
                        jedisUtil.setex(ProjectConfig.SMSCODE+message.getReceive(),180,code+"");
                    }
                    break;

            }
        }catch (Exception e){
            flag=2;
        }finally {
            //记录消息发送信息
            messageMapper.insert(message);
            //记录日志
            Tb_MessageLog log = new Tb_MessageLog();
            log.setMid(message.getId());
            log.setInfo(info);
            log.setIp(ip);
            messagelogMapper.insert(log);
            //记录收件人
            Tb_Msgreceive receive=new Tb_Msgreceive();
            receive.setNo(message.getReceive());
            receive.setFlag(message.getType()<4?1:2);
            msgreceiveMapper.insert(receive);
        }
        //记录到数据库
        return null;
    }
    //发送短信验证码
    private R sendSms(Tb_Message message,String ip){
        int count=0;
        //短信的话 需要校验 一个手机号一分钟只能发1次
        //一个手机号一天只能发20条
        //获取当前的手机号今天的发送次数
        String c=jedisUtil.get(ProjectConfig.SMSPREDAY+message.getReceive());
        if(c!=null && c.matches("[0-9]{1,2}")){
            count=Integer.parseInt(c);
            if(count>=20){
                return R.setERROR("亲，一个手机号一天只能发送指定数量的短信");
            }
        }
        //一个手机号一分钟只能发送1次
        if(jedisUtil.exists(ProjectConfig.SMSPRELIMIT+message.getReceive())){
            //存在说明1分钟只能发送过短信
            return R.setERROR("一个手机号一分钟只能发送1次短信");
        }
        int code=0;
        int flag=3;
        String info="";
        boolean isflag=false;
        if(jedisUtil.exists(ProjectConfig.SMSCODE+message.getReceive())){
            //上次的验证码还没失效
            code=Integer.parseInt(jedisUtil.get(ProjectConfig.SMSCODE+message.getReceive()));
        }else {
            code = CodeUtil.createNum(6);
            isflag=true;
        }
        info="发送短信验证码："+code;
        //验证码 三分钟有效
        SmsUtil.mobileQuery(message.getReceive(),code);
        flag=1;//发送成功
        //1分钟
        String s1=jedisUtil.setex(ProjectConfig.SMSPRELIMIT+message.getReceive(),60,"短信发送限制");
        //1天
        String s2=jedisUtil.setex(ProjectConfig.SMSPREDAY+message.getReceive(),TimeUtil.getLastSeconds(),(count+1)+"");

        if(isflag){
            //记录验证码
            String s3=jedisUtil.setex(ProjectConfig.SMSCODE+message.getReceive(),600,code+"");

        }
        save(message,info,ip);
        return R.setOK("OK",null);
    }
    //新增数据库记录
    private void save(Tb_Message message, String info, String ip){
        //记录消息发送信息
        messageMapper.insert(message);
        //记录日志
        Tb_MessageLog log = new Tb_MessageLog();
        log.setMid(message.getId());
        log.setInfo(info);
        log.setIp(ip);
        messagelogMapper.insert(log);
        //记录收件人
        Tb_Msgreceive receive=new Tb_Msgreceive();
        receive.setNo(message.getReceive());
        receive.setFlag(message.getType()<4?1:2);
        msgreceiveMapper.insert(receive);
    }

    @Override
    public R page(int page, int count) {
        PageHelper.startPage(page, count);
        PageInfo<Tb_Message> pageInfo=new PageInfo<>(messageMapper.selectAll());
        return R.setOK("OK",pageInfo);
    }

    @Override
    public R checkCode(String phone, int code) {
        String key=ProjectConfig.SMSCODE+phone;
        if(jedisUtil.exists(key)){
            String v=jedisUtil.get(key);
            if(v!=null){
                if(Integer.parseInt(v)==code){
                    return R.setOK("验证码正确",null);
                }else {
                    return R.setERROR("验证码输入错误");
                }
            }
        }
        return R.setERROR("亲，验证码过期，请重新获取验证码");
    }

    @Override
    @Transactional
    public R sendMessage(Tb_Message message, String ip) {
        if(message.getType()<4){

        }
        //短信
        return sendSms(message,ip);
    }
}
