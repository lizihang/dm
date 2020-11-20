package com.dm.quartz.service.impl;

import com.dm.quartz.dao.SystemJobDAO;
import com.dm.quartz.po.SystemJob;
import com.dm.quartz.service.SystemJobService;
import com.dm.quartz.util.JobUtils;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
 * <p>类全名：com.dm.quartz.service.impl.SystemServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service
public class SystemServiceImpl implements SystemJobService
{
	@Resource
	SystemJobDAO systemJobDAO;
	@Resource
	private Scheduler scheduler;

	@Override
	public List<SystemJob> getSystemJobs()
	{
		return systemJobDAO.getSystemJobs();
	}

	@Override
	@Transactional
	public int addSystemJob(SystemJob systemJob) throws Exception
	{
		// 1.插入数据库
		// int rows = systemJobDAO.addSystemJob(systemJob);
		int rows = 1;
		if (rows > 0)
		{
			// 2.JobUtil开启定时任务
			JobUtils.createJob(scheduler, systemJob, null);
		}
		return rows;
	}
}
