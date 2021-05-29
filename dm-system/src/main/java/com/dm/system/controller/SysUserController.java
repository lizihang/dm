package com.dm.system.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.system.util.JwtTokenUtil;
import com.dm.system.util.ServletUtil;
import com.dm.system.vo.LoginUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年05月29日 13:57</p>
 * <p>类全名：com.dm.system.controller.SysUserController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("user")
public class SysUserController
{
	@Resource
	JwtTokenUtil jwtTokenUtil;

	/**
	 * 查询所有用户列表
	 * @return result
	 */
	@DmLog
	@GetMapping("queryUserInfo")
	public Result queryUserInfo()
	{
		LoginUser loginUser = jwtTokenUtil.getLoginUser(ServletUtil.getRequest());
		return Result.success("查询用户信息成功", loginUser.getUser());
	}
}
