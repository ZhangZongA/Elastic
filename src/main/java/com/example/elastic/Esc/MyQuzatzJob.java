package com.example.elastic.Esc;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class MyQuzatzJob extends QuartzJobBean {
    protected void executeInternal (JobExecutionContext context)
    {
        System.out.println("现在的时间是"+new Date());
    }


}
