package com.dm.user.controller;

import com.dm.user.po.User;
import com.dm.user.service.UserService;
import com.dm.user.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

	@GetMapping("findAll")
	public List<User> findAll()
	{
		return userService.findAll();
	}

	@PostMapping("save")
	public Result save(@RequestBody User user)
	{
		Result result = new Result();
		try
		{
			userService.save(user);
			result.setMsg("保存成功");
		} catch (Exception e)
		{
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg("保存失败");
		}
		return result;
	}

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
}
