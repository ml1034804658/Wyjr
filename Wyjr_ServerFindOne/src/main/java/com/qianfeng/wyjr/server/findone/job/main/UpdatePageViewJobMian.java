package com.qianfeng.wyjr.server.findone.job.main;

import com.qianfeng.wyjr.server.findone.job.UpdatePageViewJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class UpdatePageViewJobMian {
    static {
        //1、创建调度器
        Scheduler scheduler;
        {
            try {
                scheduler = new StdSchedulerFactory().getScheduler();
                //2、创建作业详情
                JobDetail jobDetail=JobBuilder.newJob(UpdatePageViewJob.class).build();
                //3、创建触发器 --标记什么时候做
                //间隔2秒执行1次 执行到永远 立刻执行
                Trigger trigger=TriggerBuilder.newTrigger().withSchedule(
                        SimpleScheduleBuilder.repeatSecondlyForever(10)).startNow().build();
                System.out.println("zhixing");
                //4、设置到调度器中
                scheduler.scheduleJob(jobDetail,trigger);
                //5、启动调度器
                scheduler.start();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }

    }

}
