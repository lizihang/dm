package com.dm.user.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.user.po.User;
import com.dm.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
/**
 * <p>标题：用户Controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：用户注册，用户登录，用户修改
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
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	UserService userService;

	@DmLog
	@PostMapping("login")
	public Result login(@RequestBody User user)
	{
		logger.info("用户登录方法，用户名:{}", user.getUsername());
		Result result = new Result();
		User u = userService.login(user);
		if (u != null)
		{
			// 登录成功将用户返回
			result.setMsg("登录成功!");
			result.getData().put("user", u);
		} else
		{
			result.setStatus(false);
			result.setMsg("用户名或密码错误！");
		}
		return result;
	}

	@PostMapping("register")
	public Result register(@RequestBody User user)
	{
		Result result = new Result();
		try
		{
			User u = userService.register(user);
			// 注册成功将用户返回
			result.setMsg("注册成功!");
			result.getData().put("user", u);
		} catch (Exception e)
		{
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}

	@PostMapping("update")
	public Result update(@RequestBody User user)
	{
		Result result = new Result();
		try
		{
			userService.update(user);
			result.setMsg("修改成功");
		} catch (Exception e)
		{
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("修改失败");
		}
		return result;
	}

	@GetMapping("queryList")
	public List<User> queryList()
	{
		logger.info("查询所有用户方法");
		return userService.queryList();
	}

	/*
	@DeleteMapping("deleteById")
	public Result deleteById(int id)
	{
		Result result = new Result();
		try
		{
			userService.deleteById(id);
			result.setMsg("删除成功，用户id：" + id);
		} catch (Exception e)
		{
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("删除失败");
		}
		return result;
	}
	*/
}
