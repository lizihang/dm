package com.dm.quartz.study;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月19日 15:07</p>
 * <p>类全名：com.dm.quartz.study.QuartzJob</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class QuartzJob implements Job
{
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		// 获取JobDetail中的JobDataMap
		JobDataMap jobDetailDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		// 获取Trigger中的JobDataMap
		JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
		// 合并的JobDataMap，要注意两个map的键不能重复，否则覆盖掉
		JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
		System.out.println("jobDetailDataMap中的msg：" + jobDetailDataMap.get("msg"));
		System.out.println("triggerDataMap中的msg：" + triggerDataMap.get("msg"));
		System.out.println("triggerDataMap中的msg：" + mergedJobDataMap.get("msg"));
	}
}
