package com.example.elastic.Esc;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuzatzConfig {
    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(MyQuzatzJob.class)
                .withIdentity("定时任务——报告时间")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger printTimeJobTrigger()
    {
        CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //用于设置多长时间执行一次   如果第一个参数是5 那么会在每个分钟第五秒输出一次  如果是0/5才是每五秒输出一次
        return (Trigger) TriggerBuilder.newTrigger()
                .forJob("定时任务——报告时间")
                .withIdentity("Trigger-name").withSchedule(cronScheduleBuilder).build();//关联上面的任务


    }
}
