package com.dm.quartz.vo;

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
 * <p>创建日期：2020年11月18日 10:56</p>
 * <p>类全名：com.dm.quartz.vo.TestJob</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class TestJob extends QuartzJobBean
{
	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		System.out.println("测试quartz定时任务" + new Date());
	}
}
