package com.dm.quartz.test;

import java.util.Date;
/**
 * <p>标题：springboot自带定时任务</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月18日 11:26</p>
 * <p>类全名：com.dm.quartz.test.ScheduleTask</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
//@Component
public class ScheduleTask
{
	//@Scheduled(cron = "0/5 * * * * ?")
	public void hello()
	{
		System.out.println("hello" + new Date());
	}
}
