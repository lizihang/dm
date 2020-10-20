package com.dm.user.controller;

import com.dm.user.po.User;
import com.dm.user.service.UserService;
import com.dm.user.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
	@Resource
	UserService userService;

	@PostMapping("login")
	public Result login(@RequestBody User user)
	{
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

	@PostMapping("regist")
	public Result regist(@RequestBody User user)
	{
		Result result = new Result();
		try
		{
			userService.regist(user);
			result.setMsg("保存成功");
		} catch (Exception e)
		{
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("保存失败");
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

	/*
	@GetMapping("queryList")
	public List<User> queryList()
	{
		return userService.findAll();
	}
	*/

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
