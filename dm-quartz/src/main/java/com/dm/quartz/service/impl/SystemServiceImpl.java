package com.dm.quartz.service.impl;

import com.dm.quartz.constants.JobConstants;
import com.dm.quartz.dao.SystemJobDAO;
import com.dm.quartz.po.SystemJob;
import com.dm.quartz.service.SystemJobService;
import com.dm.quartz.util.JobUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
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
	Scheduler    scheduler;

	@Override
	public List<SystemJob> getSystemJobs()
	{
		return systemJobDAO.queryList();
	}

	@Override
	@Transactional
	public int addSystemJob(SystemJob systemJob) throws Exception
	{
		// TODO 利用aop add*方法处理创建人，创建时间 update*处理修改人，修改时间
		// 1.插入数据库
		int rows = systemJobDAO.save(systemJob);
		if (rows > 0)
		{
			// 2.JobUtil开启定时任务
			JobUtils.createJob(scheduler, systemJob, null);
		}
		return systemJob.getJobId();
	}

	@Override
	public int updateSystemJob(SystemJob systemJob) throws SchedulerException
	{
		SystemJob oldJob = systemJobDAO.queryJobById(systemJob.getJobId());
		int rows = systemJobDAO.updateJob(systemJob);
		if (rows > 0)
		{
			// 修改了cron执行表达式
			if (!oldJob.getCronExpression().equals(systemJob.getCronExpression()))
			{
				JobUtils.rescheduleJob(scheduler, systemJob);
			}
			//暂停状态->运行状态
			if (oldJob.getStatus().equals(JobConstants.JOB_STATUS_PAUSE) && systemJob.getStatus().equals(JobConstants.JOB_STATUS_START))
			{
				JobUtils.resumeJob(scheduler, systemJob);
			}
			//运行状态->暂停状态
			if (oldJob.getStatus().equals(JobConstants.JOB_STATUS_START) && systemJob.getStatus().equals(JobConstants.JOB_STATUS_PAUSE))
			{
				JobUtils.pauseJob(scheduler, systemJob);
			}
		}
		return systemJob.getJobId();
	}

	@Override
	public int deleteJob(SystemJob systemJob) throws SchedulerException
	{
		SystemJob oldJob = systemJobDAO.queryJobById(systemJob.getJobId());
		if (oldJob == null)
		{
			return 0;
		}
		int rows = systemJobDAO.deleteJobById(systemJob.getJobId());
		if (rows > 0)
		{
			JobUtils.deleteJob(scheduler, oldJob);
		}
		return systemJob.getJobId();
	}
}
