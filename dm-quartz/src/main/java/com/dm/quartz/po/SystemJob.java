package com.dm.quartz.po;

import com.dm.po.BasePO;
/**
 * <p>标题：系统任务PO</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月20日 15:18</p>
 * <p>类全名：com.dm.quartz.po.SystemJob</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class SystemJob extends BasePO
{
	private static final long   serialVersionUID = 2994114341149006072L;
	/** 任务ID */
	private              int    jobId;
	/** 任务名称 */
	private              String jobName;
	/** 任务组名 */
	private              String jobGroup;
	/** 任务类 */
	private              String jobClass;
	/** cron执行表达式 */
	private              String cronExpression;
	/** 时区 */
	private              String timeZoneId;
	/** 是否并发执行（0允许 1禁止） */
	private              String concurrent;
	/** 任务状态（0正常 1暂停） */
	private              String status;

	public int getJobId()
	{
		return jobId;
	}

	public void setJobId(int jobId)
	{
		this.jobId = jobId;
	}

	public String getJobName()
	{
		return jobName;
	}

	public void setJobName(String jobName)
	{
		this.jobName = jobName;
	}

	public String getJobGroup()
	{
		return jobGroup;
	}

	public void setJobGroup(String jobGroup)
	{
		this.jobGroup = jobGroup;
	}

	public String getJobClass()
	{
		return jobClass;
	}

	public void setJobClass(String jobClass)
	{
		this.jobClass = jobClass;
	}

	public String getCronExpression()
	{
		return cronExpression;
	}

	public void setCronExpression(String cronExpression)
	{
		this.cronExpression = cronExpression;
	}

	public String getTimeZoneId()
	{
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId)
	{
		this.timeZoneId = timeZoneId;
	}

	public String getConcurrent()
	{
		return concurrent;
	}

	public void setConcurrent(String concurrent)
	{
		this.concurrent = concurrent;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "SystemJob{" + "jobId=" + jobId + ", jobName='" + jobName + '\'' + ", jobGroup='" + jobGroup + '\'' + ", jobClass='" + jobClass + '\'' + ", cronExpression='" + cronExpression + '\'' + ", timeZoneId='" + timeZoneId + '\'' + ", concurrent='" + concurrent + '\'' + ", status='" + status + '\'' + "} " + super.toString();
	}
}

