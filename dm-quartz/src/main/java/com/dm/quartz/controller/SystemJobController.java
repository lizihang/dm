package com.dm.quartz.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.quartz.po.SystemJob;
import com.dm.quartz.service.SystemJobService;
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
public class SystemJobController
{
	@Resource()
	SystemJobService systemJobService;

	@GetMapping("getSystemJobs")
	public Result getSystemJobs()
	{
		Result result = new Result();
		List<SystemJob> data = systemJobService.getSystemJobs();
		result.setMsg("查询系统定时任务成功！");
		result.getData().put("systemjobs", data);
		return result;
	}

	@DmLog
	@PostMapping("addSystemJob")
	public Result addSystemJob(@RequestBody SystemJob systemJob) throws Exception
	{
		Result result = new Result();
		systemJobService.addSystemJob(systemJob);
		// 注册成功将用户返回
		result.setMsg("添加任务成功!");
		return result;
	}
}
