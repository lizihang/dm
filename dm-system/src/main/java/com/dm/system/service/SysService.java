package com.dm.system.service;

import com.dm.system.vo.Menus;

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
 * <p>类全名：com.dm.system.service.SysService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface SysService
{
	List<Menus> getMenus();
}
