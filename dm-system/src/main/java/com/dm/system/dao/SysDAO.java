package com.dm.system.dao;

import com.dm.system.po.Menu;
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
 * <p>创建日期：2020年11月10日 9:45</p>
 * <p>类全名：com.dm.system.dao.SysDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface SysDAO
{
	List<Menu> getMenu();
}