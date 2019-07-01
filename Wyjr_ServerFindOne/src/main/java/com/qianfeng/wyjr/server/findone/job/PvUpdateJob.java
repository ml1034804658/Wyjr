package com.qianfeng.wyjr.server.findone.job;

import com.jr.common.config.ProjectConfig;
import com.jr.common.util.JedisUtil;
import com.qianfeng.wyjr.server.findone.service.impl.FindOtherServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*@Component*/
public class PvUpdateJob implements Job {

  /*  @Autowired
    private FindOtherService findOtherService;*/
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        FindOtherServiceImpl findOtherService = new FindOtherServiceImpl();
        for (int i = 0 ; i< 10000; i++) {
            String spageview = ProjectConfig.PAGEVIEW + i ;
            if (JedisUtil.getInstance().exists(spageview)){
                String thisspageview = JedisUtil.getInstance().get(spageview);
                long jid = i;
                int pageview =  Integer.parseInt(thisspageview);
                System.out.println("jid="+jid);
                System.out.println("pageview = " + pageview);
                new FindOtherServiceImpl().updatePageView(jid,pageview);
            }
        }
    }
}
