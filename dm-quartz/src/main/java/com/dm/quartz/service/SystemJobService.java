package com.dm.quartz.service;

import com.dm.quartz.po.SystemJob;

import java.util.List;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月20日 15:24</p>
 * <p>类全名：com.dm.quartz.service.SystemJobService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface SystemJobService
{
	/**
	 * 查询所有定时任务
	 * @return
	 */
	List<SystemJob> getSystemJobs();

	int addSystemJob(SystemJob systemJob) throws Exception;
}
