package com.dm.user.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.user.po.DmUser;
import com.dm.user.service.UserService;
import com.dm.user.vo.DmUserQueryParams;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
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
	 * @return result
	 */
	@DmLog
	@GetMapping("queryList")
	@PreAuthorize("@ps.permission('user:query')")
	public Result queryList(DmUserQueryParams params)
	{
		Map<String,Object> data = new HashMap<>();
		data.put("users",userService.queryList(params));
		data.put("total",userService.queryTotal(params));
		return Result.success("查询用户列表成功", data);
	}

	/**
	 * 注册用户
	 * @param user 用户
	 * @return result
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
	 * @param user 用户
	 * @return result
	 */
	@DmLog
	@PostMapping("updateUser")
	@PreAuthorize("@ps.permission('user:update')")
	public Result updateUser(@RequestBody DmUser user)
	{
		userService.updateUser(user);
		return Result.success("用户修改成功");
	}

	/**
	 * 逻辑删除
	 * @param id id
	 * @return result
	 */
	@DmLog
	@DeleteMapping("deleteUserById")
	@PreAuthorize("@ps.permission('user:delete')")
	public Result deleteUserByLogic(int id)
	{
		userService.deleteUserByLogic(id);
		return Result.success("删除成功，用户id：" + id);
	}

	/**
	 * 彻底删除
	 * @param id
	 * @return
	 */
	@DmLog
	@DeleteMapping("deleteCompletely")
	@PreAuthorize("@ps.permission('user:delete')")
	public Result deleteCompletely(int id)
	{
		userService.deleteUserById(id);
		return Result.success("删除成功，用户id：" + id);
	}
}
