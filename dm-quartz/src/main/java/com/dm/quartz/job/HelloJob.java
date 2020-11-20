package com.dm.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月20日 15:14</p>
 * <p>类全名：com.dm.quartz.job.HelloJob</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class HelloJob extends QuartzJobBean
{
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		System.out.println("HelloJob " + new Date());
	}
}
