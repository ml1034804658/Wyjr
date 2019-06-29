package com.qianfeng.wyjr.server.findone.job;

import com.jr.common.util.JedisUtil;
import com.jr.entity.Tb_Findothers;
import com.qianfeng.wyjr.server.findone.dao.Tb_FindothersMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import com.qianfeng.wyjr.server.findone.service.impl.FindOtherServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.List;

public class UpdatePageViewJob implements Job {

    @Autowired
    private Tb_FindothersMapper tb_findothersMapper;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<Tb_Findothers> list_tb_findothers = tb_findothersMapper.selectAllByHot();
        JedisUtil instance = JedisUtil.getInstance();
        for (int i=0; i<list_tb_findothers.size(); i++) {
            Tb_Findothers li = list_tb_findothers.get(i);
            instance.set("jid"+ i, String.valueOf(li.getJid()));
            instance.set("uid"+ i, String.valueOf(li.getUid()));
            instance.set("route"+ i, li.getRoute());
            instance.set("content"+ i, li.getContent());
            instance.set("createtime"+ i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(li.getCreatetime()));
            instance.set("pageview"+ i, String.valueOf(li.getPageview()));
            instance.set("imageurl"+ i, li.getImageurl());
            System.out.println(li.getImageurl());
        }
        instance.set("list_count", String.valueOf(list_tb_findothers.size()));

    }
}
