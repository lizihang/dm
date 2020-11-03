package com.dm.log.dao;

import com.dm.log.po.DmLog;
import org.apache.ibatis.annotations.Mapper;

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
 * <p>创建日期：2020年11月03日 15:40</p>
 * <p>类全名：com.dm.log.dao.LogDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface LogDAO
{
	List<DmLog> queryList(String logType);
}
