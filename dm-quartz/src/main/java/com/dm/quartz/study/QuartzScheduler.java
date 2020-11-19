package com.dm.quartz.study;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月19日 15:10</p>
 * <p>类全名：com.dm.quartz.study.QuartzScheduler</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class QuartzScheduler
{
	public static void main(String[] args) throws SchedulerException
	{
		// 传递数据的map
		JobDataMap jobDetailDataMap = new JobDataMap();
		jobDetailDataMap.put("msg", "this is jobDetailDataMap test msg");
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
				// 指定JobDetail的名称和组名称
				.withIdentity("study", "study")
				// 使用JobDataMap存储用户数据
				.usingJobData(jobDetailDataMap).build();
		// 设置cron运行规则
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/15 * * * * ?");
		// 传递数据的map
		JobDataMap triggerDataMap = new JobDataMap();
		triggerDataMap.put("msg", "this is triggerDataMap test msg");
		Trigger trigger = TriggerBuilder.newTrigger()
				// 设置运行规则
				.withSchedule(cronScheduleBuilder)
				// 使用JobDataMap存储用户数据
				.usingJobData(triggerDataMap).build();
		// 调度器运行job
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
