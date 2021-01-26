package com.dm.user.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.user.po.User;
import com.dm.user.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
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

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	//TODO SpringSecurity登录，所以不走这个
	@DmLog
	@PostMapping("login")
	public Result login(@RequestBody User user)
	{
		User u = userService.login(user);
		if (u != null)
		{
			// 登录成功将用户返回
			return Result.success("登录成功!", u);
		} else
		{
			return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "用户名或密码错误！");
		}
	}

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@DmLog
	@PostMapping("register")
	public Result register(@RequestBody User user)
	{
		// TODO 验证参数不为空
		User u = userService.register(user);
		// 注册成功将用户返回
		return Result.success("注册成功!", u);
	}

	/**
	 * 用户更新
	 * @param user
	 * @return
	 */
	@DmLog
	@PostMapping("update")
	public Result update(@RequestBody User user)
	{
		userService.update(user);
		return Result.success("修改成功");
	}

	/**
	 * 查询所有用户列表
	 * @return
	 */
	@DmLog
	@GetMapping("queryList")
	public List<User> queryList()
	{
		logger.info("查询所有用户方法");
		return userService.queryList();
	}

	/**
	 * 根据ID删除用户
	 * @param id
	 * @return
	 */
	@DmLog
	@DeleteMapping("deleteById")
	public Result deleteById(int id)
	{
		userService.deleteById(id);
		return Result.success("删除成功，用户id：" + id);
	}

	private void validUser(User user) throws IllegalAccessException
	{
		//TODO 是否有统一处理方法
		Field[] fields = User.class.getDeclaredFields();
		for (Field f : fields)
		{
			String fieldName = f.getName();
			f.setAccessible(true);
			Object fieldValue = f.get(user);
			boolean isNotNull = f.isAnnotationPresent(NotNull.class);
			if (isNotNull && ObjectUtils.isEmpty(fieldValue))
			{
				System.out.println("字段：" + fieldName + "不能为空！");
			}
		}
	}
}
