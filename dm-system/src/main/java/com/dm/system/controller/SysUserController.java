package com.dm.system.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.system.util.JwtTokenUtil;
import com.dm.system.util.ServletUtil;
import com.dm.system.vo.LoginUser;
import com.dm.user.po.DmUser;
import com.dm.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
	private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
	@Resource
	JwtTokenUtil jwtTokenUtil;
	@Resource
	UserService  userService;

	/**
	 * 查询用户信息
	 * @return result
	 */
	@DmLog
	@GetMapping("queryUserInfo")
	public Result queryUserInfo()
	{
		LoginUser loginUser = jwtTokenUtil.getLoginUser(ServletUtil.getRequest());
		return Result.success("查询用户信息成功", loginUser.getUser());
	}

	@DmLog
	@PostMapping("updateAvatar")
	public Result updateAvatar(@RequestParam("avatar") MultipartFile file)
	{
		if (!file.isEmpty())
		{
			String fileName = file.getOriginalFilename();
			int size = (int) file.getSize();
			System.out.println(fileName + "-->" + size);
			String path = "D:/dm/upload/avatar/";
			LoginUser loginUser = jwtTokenUtil.getLoginUser(ServletUtil.getRequest());
			DmUser user = loginUser.getUser();
			String username = user.getUsername();
			String avatar = username + "/" + fileName;
			File dest = new File(path + avatar);
			if (!dest.getParentFile().exists())
			{
				//判断文件父目录是否存在
				boolean success = dest.getParentFile().mkdirs();
				if (success)
				{
					logger.info("创建目录成功！" + dest.getAbsolutePath());
				} else
				{
					logger.error("创建目录失败！" + dest.getAbsolutePath());
				}
			}
			try
			{
				// 1.保存文件
				file.transferTo(dest);
				// 2.更新用户avatar字段
				user.setAvatar(avatar);
				userService.updateUser(user);
				// TODO
				// 3.更新缓存
				// 4.更新token
				// 5.返回结果
				return Result.success("头像上传成功", loginUser);
			} catch (IllegalStateException | IOException e)
			{
				e.printStackTrace();
			}
		}
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "上传文件不能为空！");
	}
}
