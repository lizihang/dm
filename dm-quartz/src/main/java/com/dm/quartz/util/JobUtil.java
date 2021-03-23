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
 * <p>类全名：com.dm.quartz.util.JobUtil</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class JobUtil
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

	/**
	 * 创建任务
	 * @param scheduler
	 * @param job
	 * @param jobDataMap
	 * @throws Exception
	 */
	public static void createJob(Scheduler scheduler, SystemJob job, JobDataMap jobDataMap) throws SchedulerException, IllegalAccessException, InstantiationException, ClassNotFoundException
	{
		jobDataMap = jobDataMap == null ? new JobDataMap() : jobDataMap;
		//构建job信息
		JobDetail jobDetail = JobBuilder.newJob(getClass(job.getJobClass()))
				// 指定JobDetail的名称和组名称
				.withIdentity(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup())
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
				.withIdentity(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup())
				// 指定表达式
				.withSchedule(builder)
				//
				.build();
		// 配置scheduler相关参数
		scheduler.scheduleJob(jobDetail, trigger);
		// 启动调度器
		scheduler.start();
	}

	/**
	 * 暂停任务
	 * @param scheduler
	 * @param job
	 * @throws Exception
	 */
	public static void pauseJob(Scheduler scheduler, SystemJob job) throws SchedulerException
	{
		scheduler.pauseJob(JobKey.jobKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup()));
	}

	/**
	 * 恢复任务
	 * @param scheduler
	 * @param job
	 * @throws Exception
	 */
	public static void resumeJob(Scheduler scheduler, SystemJob job) throws SchedulerException
	{
		scheduler.resumeJob(JobKey.jobKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup()));
	}

	/**
	 * 重新设置任务
	 * @param scheduler
	 * @param job
	 * @throws Exception
	 */
	public static void rescheduleJob(Scheduler scheduler, SystemJob job) throws SchedulerException
	{
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup());
		CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		// 按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder()
				// 指定trigger的名称和组名称
				.withIdentity(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup())
				// 指定表达式
				.withSchedule(builder)
				//
				.build();
		// 按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
	}

	/**
	 * 删除任务
	 * @param scheduler
	 * @param job
	 * @throws Exception
	 */
	public static void deleteJob(Scheduler scheduler, SystemJob job) throws SchedulerException
	{
		scheduler.pauseTrigger(TriggerKey.triggerKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup()));
		scheduler.unscheduleJob(TriggerKey.triggerKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup()));
		scheduler.deleteJob(JobKey.jobKey(job.getJobGroup() + "-" + job.getJobId(), job.getJobGroup()));
	}
}
