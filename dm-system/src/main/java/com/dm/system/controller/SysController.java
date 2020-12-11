package com.dm.system.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.system.service.SysService;
import com.dm.system.vo.Menus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>标题：系统相关功能Controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * 功能：
 * 1.系统菜单的增删改查
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月10日 9:45</p>
 * <p>类全名：com.dm.system.controller.SysController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("system")
public class SysController
{
	@Resource
	SysService sysService;

	/**
	 * 获取系统菜单
	 * @return
	 */
	@DmLog
	@GetMapping("getMenus")
	public Result getMenus()
	{
		List<Menus> menus = sysService.getMenus();
		return Result.success("获取系统菜单成功！", menus);
	}
}
