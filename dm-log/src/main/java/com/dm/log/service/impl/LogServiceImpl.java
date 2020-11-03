package com.dm.log.service.impl;

import com.dm.log.dao.LogDAO;
import com.dm.log.po.DmLog;
import com.dm.log.service.LogService;
import org.springframework.stereotype.Service;

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
 * <p>创建日期：2020年11月03日 15:36</p>
 * <p>类全名：com.dm.log.service.impl.LogServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service
public class LogServiceImpl implements LogService
{
	@Resource
	LogDAO logDAO;

	@Override
	public List<DmLog> queryList(String logType)
	{
		return logDAO.queryList(logType);
	}
}
