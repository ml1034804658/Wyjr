package com.qianfeng.wyjr.server.findone.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.exception.FindOneException;
import com.jr.common.util.JedisUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.jr.entity.Tb_Findothers_Comment;
import com.qianfeng.wyjr.server.findone.dao.Tb_FindothersMapper;
import com.qianfeng.wyjr.server.findone.dao.Tb_Findothers_CommentMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindOtherServiceImpl implements FindOtherService {

    @Autowired private Tb_FindothersMapper tb_findothersMapper;

    @Autowired
    private Tb_Findothers_CommentMapper tb_findothers_commentMapper;

    //最新捡人
    @Override
    public R selectAll() {
        List<Tb_Findothers> list_tb_findothers = tb_findothersMapper.selectAll();
        return R.setOK("OK", list_tb_findothers);
    }

    //最热捡人
    public R selectAllByHot() {
        JedisUtil instance = JedisUtil.getInstance();

        Tb_Findothers tb_findothers = new Tb_Findothers();

        List<Tb_Findothers> list = new ArrayList<>();

        for (int i=0; i<Integer.parseInt(instance.get("list_count")); i++) {
            tb_findothers.setJid(Long.getLong(instance.get("jid"+i)));
            System.out.println(Long.getLong(instance.get("jid"+i)));
            tb_findothers.setUid(Integer.parseInt(instance.get("uid"+ i)));
            tb_findothers.setRoute(instance.get("route"+ i));
            tb_findothers.setContent(instance.get("content"+ i));
            try {
                tb_findothers.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(instance.get("createtime"+ i)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tb_findothers.setPageview(Integer.parseInt(instance.get("pageview"+ i)));
            tb_findothers.setImageurl(instance.get("imageurl"+ i));

            list.add(tb_findothers);
        }
        return R.setOK("OK", list) ;
    }


    @Override
    public R selectByPrimaryKey(Long jid) {
        Tb_Findothers tb_findothers = tb_findothersMapper.selectByPrimaryKey(jid);
        return R.setOK("OK",tb_findothers);
    }

    @Override
    public R savemsg(Tb_Findothers findothers) throws FindOneException{
        try {
            tb_findothersMapper.insert(findothers);
            return R.setOK();
        } catch (Exception e) {
            throw  new FindOneException("插入失败");
        }
    }

    @Override
    @Transactional(rollbackFor = {FindOneException.class})
    public R selectDetailByJid(Long jid) throws FindOneException {
        // 查找检人的信息
        try {
            Tb_Findothers tb_findothers = tb_findothersMapper.selectByPrimaryKey(jid);
            //System.out.println("检人信息"+tb_findothers);
            List<Tb_Findothers_Comment> tb_findothers_comments = tb_findothers_commentMapper.selectByJid(jid);
            // 判断redis中是否有该条信息的浏览量
            String pageview = ProjectConfig.PAGEVIEW+jid;
            if(JedisUtil.getInstance().exists(pageview)){
                // redis中存在该检人信息的浏览量加一
                JedisUtil.getInstance().incr(pageview);
            }else {
                // redis中不存在这个检人信息的浏览量
                long thispageview = tb_findothers.getPageview();// 获取当前检人信息的浏览量
                // System.out.println("当前信息的浏览量"+thispageview);
                // 将当前检人信息的浏览数存储到redis中
                JedisUtil.getInstance().set(pageview, thispageview + 1 + "");
            }
            return R.setOK("ok",tb_findothers_comments);
        } catch (Exception e) {
            throw  new FindOneException("啊哦~网络崩溃了");
        }
    }

    @Override
    public void updatePageView(long jid, int pageview) {
        //System.out.println("service中的jid:" + jid);
        tb_findothersMapper.updatePageView(jid,pageview);
    }


}
