package com.dm.log.controller;

import com.dm.common.util.RedisUtil;
import com.dm.log.po.DmLog;
import com.dm.log.service.LogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * <p>创建日期：2020年11月03日 14:54</p>
 * <p>类全名：com.dm.log.controller.LogController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("log")
public class LogController
{
	@Resource
	LogService logService;
	@Resource
	RedisUtil  redisUtil;

	/**
	 * 查询日志信息
	 * @param logType 日志类型：err,info...
	 * @return 日志list
	 */
	@GetMapping("queryLogs")
	public List<DmLog> queryList(String logType)
	{
		List<DmLog> dmLogs = logService.queryList(logType);
		// 测试redisUtil
		redisUtil.set("dmlogs", dmLogs, 30);
		return dmLogs;
	}
}
