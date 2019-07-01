package com.qianfeng.wyjr.server.findone.job.main.utils;


import com.qianfeng.wyjr.server.findone.job.PvUpdateJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * cron触发器的封装类
 */
public class CRONutil  {

    public void Cron() throws SchedulerException {
        // 1.创建一个调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 2. 创建一个作业的详情
        JobDetail jobDetail = JobBuilder.newJob(PvUpdateJob.class).build();
        // 3.创建一个触发器 每5分钟执行一次
        CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ? ")).build();
        // 4.设置到调度器中
        scheduler.scheduleJob(jobDetail,trigger);
        // 5.启动调度器
        scheduler.start();
    }

}
