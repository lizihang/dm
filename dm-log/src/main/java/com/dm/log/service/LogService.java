package com.dm.log.service;

import com.dm.log.po.DmLog;

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
 * <p>创建日期：2020年11月03日 15:35</p>
 * <p>类全名：com.dm.log.service.LogService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface LogService
{
	List<DmLog> queryList(String logType);
}
