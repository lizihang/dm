package com.dm.quartz.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.quartz.po.SystemJob;
import com.dm.quartz.service.SystemJobService;
import io.swagger.annotations.*;
import org.quartz.SchedulerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
 * <p>创建日期：2020年11月20日 15:22</p>
 * <p>类全名：com.dm.quartz.controller.SystemJobController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("system")
@Api(tags = "定时任务controller")
public class SystemJobController
{
	@Resource()
	SystemJobService systemJobService;

	/**
	 *
	 * @return
	 */
	@DmLog
	@ApiOperation("新增定时任务")
	@PreAuthorize("@ps.permission('system:job:query')")
	@GetMapping("getSystemJobs")
	public Result getSystemJobs()
	{
		List<SystemJob> data = systemJobService.getSystemJobs();
		return Result.success("查询系统定时任务成功！", data);
	}

	/**
	 * 新增定时任务
	 * @param systemJob
	 * @return
	 * @throws Exception
	 */
	@DmLog
	@ApiOperation("新增定时任务")
	@PreAuthorize("@ps.permission('system:job:add')")
	@PostMapping("addSystemJob")
	public Result addSystemJob(@RequestBody SystemJob systemJob) throws Exception
	{
		int jobId = systemJobService.addSystemJob(systemJob);
		// 注册成功将用户返回
		return Result.success("添加任务成功!", jobId);
	}

	/**
	 * 修改定时任务
	 * @param systemJob
	 * @return
	 * @throws SchedulerException
	 */
	@DmLog
	@PostMapping("updateSystemJob")
	public Result updateSystemJob(@RequestBody SystemJob systemJob) throws SchedulerException
	{
		int jobId = systemJobService.updateSystemJob(systemJob);
		String msg = jobId == -1 ? "修改记录不存在!" : "修改任务成功!";
		return Result.success(msg, jobId);
	}

	/**
	 * 删除任务
	 * @param systemJob
	 * @return
	 * @throws SchedulerException
	 */
	@DmLog
	@PostMapping("deleteJob")
	public Result deleteJob(@RequestBody SystemJob systemJob) throws SchedulerException
	{
		int jobId = systemJobService.deleteJob(systemJob);
		String msg = jobId == -1 ? "删除记录不存在!" : "删除任务成功!";
		return Result.success(msg, jobId);
	}
}
