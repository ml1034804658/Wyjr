//package com.jr.question.config;
//
//import com.jr.question.job.QuestionAnswersRedisUpdateJob;
//import org.quartz.Trigger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//@Configuration
//public class QuartzConfig {
//
//    /**
//     * 配置定时任务 Detail
//     * @param job
//     * @return
//     */
//    @Bean(name = "jobDetail")
//    public MethodInvokingJobDetailFactoryBean detailFactoryBean(QuestionAnswersRedisUpdateJob job){// job为需要执行的任务
//        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
//        /*  是否并发执行
//     *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
//     *  如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
//      */
//        jobDetail.setConcurrent(false);
//        jobDetail.setName("std-chhliu");//设置任务名字
//        jobDetail.setGroup("std");//设置任务的分组，这些属性都可以存储在sh数据库中，在多任务的时候使用
//        /**
//         * 为需要执行的实体类对象
//         */
//        jobDetail.setTargetObject(job);
//        jobDetail.setTargetMethod("Out");
//        return jobDetail;
//    }
//
//    /**
//     * 配置触发器 Trigger
//     */
//    @Bean(name = "jobTrigger")
//    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail){
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(jobDetail.getObject());
//        trigger.setCronExpression("0 30 20 * * ?");//初始时的cron表达式
//        trigger.setName("srd-chhliu");//trigger的name
//        return trigger;
//    }
//
//    /**
//     * 设置调度器 Scheduler
//     * 定义quartz调度工厂
//     */
//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactory(Trigger jobTrigger){
//        SchedulerFactoryBean bean = new SchedulerFactoryBean();
//        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
//        bean.setOverwriteExistingJobs(true);
//        // 延时启动，应用启动1秒后
//        bean.setStartupDelay(1);
//        // 注册触发器
//        bean.setTriggers(jobTrigger);
//        return bean;
//    }
//}
