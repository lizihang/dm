package com.dm.quartz.util;

import com.dm.quartz.po.SystemJob;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月20日 15:38</p>
 * <p>类全名：com.dm.quartz.util.JobUtils</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class JobUtils
{
	/**
	 *
	 * @param className
	 * @return
	 */
	public static Class<? extends QuartzJobBean> getClass(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		Class<?> clazz = Class.forName(className);
		QuartzJobBean jobBean = (QuartzJobBean) clazz.newInstance();
		return jobBean.getClass();
	}

	public static void createJob(Scheduler scheduler, SystemJob job, JobDataMap jobDataMap) throws Exception
	{
		jobDataMap = jobDataMap == null ? new JobDataMap() : jobDataMap;
		// 启动调度器
		scheduler.start();
		//构建job信息
		JobDetail jobDetail = JobBuilder.newJob(JobUtils.getClass(job.getJobClass()))
				// 指定JobDetail的名称和组名称
				.withIdentity(job.getJobName(), job.getJobGroup())
				// 使用JobDataMap存储用户数据
				.usingJobData(jobDataMap)
				//
				.storeDurably()
				//
				.build();
		//表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
		//按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder.newTrigger()
				// 指定trigger的名称和组名称
				.withIdentity(job.getJobName(), job.getJobGroup())
				// 指定表达式
				.withSchedule(builder)
				//
				.build();
		// 配置scheduler相关参数
		scheduler.scheduleJob(jobDetail, trigger);
	}

	public static void pauseJob(Scheduler scheduler, String jobClassName, String jobGroupName) throws Exception
	{
		scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	public static void resumeJob(Scheduler scheduler, String jobClassName, String jobGroupName) throws Exception
	{
		scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
	}

	public static void rescheduleJob(Scheduler scheduler, String jobClassName, String jobGroupName, String cronExpression) throws Exception
	{
		TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
		CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(cronExpression);
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		// 按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder().withIdentity(jobClassName, jobGroupName).withSchedule(builder).build();
		// 按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
	}

	public static void deleteJob(Scheduler scheduler, String jobClassName, String jobGroupName) throws Exception
	{
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
	}
}
