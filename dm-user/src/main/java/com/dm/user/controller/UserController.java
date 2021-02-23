package com.dm.user.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.user.po.DmUser;
import com.dm.user.service.UserService;
import com.dm.user.vo.DmUserQueryParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * <p>标题：用户Controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：用户查询，注册，修改，删除
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月13日 17:03</p>
 * <p>类全名：com.dm.user.controller.UserController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin //解决跨域问题
@RestController
@RequestMapping("user")
public class UserController
{
	@Resource
	UserService userService;

	/**
	 * 查询所有用户列表
	 * @return
	 */
	@DmLog
	@GetMapping("queryList")
	public Result queryList(DmUserQueryParams params)
	{
		return Result.success("查询用户列表成功", userService.queryList(params));
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@DmLog
	@PostMapping("register")
	public Result register(@RequestBody DmUser user)
	{
		userService.register(user);
		return Result.success("用户注册成功!");
	}

	/**
	 * 用户更新
	 * @param user
	 * @return
	 */
	@DmLog
	@PostMapping("update")
	public Result update(@RequestBody DmUser user)
	{
		userService.update(user);
		return Result.success("用户修改成功");
	}

	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	@DmLog
	@DeleteMapping("deleteById")
	public Result deleteById(int id)
	{
		userService.deleteLogic(id);
		return Result.success("删除成功，用户id：" + id);
	}

	/**
	 * 彻底删除
	 * @param id
	 * @return
	 */
	@DmLog
	@DeleteMapping("deleteCompletely")
	public Result deleteCompletely(int id)
	{
		userService.deleteById(id);
		return Result.success("删除成功，用户id：" + id);
	}
}
