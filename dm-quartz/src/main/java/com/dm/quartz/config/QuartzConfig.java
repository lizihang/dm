package com.dm.quartz.config;

import com.dm.quartz.vo.TestJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月18日 10:48</p>
 * <p>类全名：com.dm.quartz.config.QuartzConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
public class QuartzConfig
{
	@Bean
	public JobDetail sampleJobDetail()
	{
		// 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
		return JobBuilder.newJob(TestJob.class).withIdentity("sampleJob").storeDurably().build();
	}

	@Bean
	public Trigger sampleJobTrigger()
	{
		// 每隔两秒执行一次
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}
}
