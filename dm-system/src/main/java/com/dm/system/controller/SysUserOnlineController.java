package com.dm.system.controller;

import com.dm.common.util.RedisCache;
import com.dm.common.vo.Result;
import com.dm.system.constants.SystemConstants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
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
 * <p>创建日期：2020年12月08日 15:02</p>
 * <p>类全名：com.dm.system.controller.SysUserOnlineController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("/monitor/online")
public class SysUserOnlineController
{
	@Resource
	RedisCache redisCache;

	@GetMapping("list")
	public Result onlineList(String username)
	{
		Result result = new Result();
		// 1.获取缓存中所有登录用户的key
		Collection<String> keys = redisCache.keys(SystemConstants.LOGIN_TOKEN_KEY + "*");
		//
		List<Object> onlineList = new ArrayList<>();
		// 2.根据key获取登录用户对象
		for (String key : keys)
		{
			// LoginUser user = redisCache.getCacheObject(key);
			// if (StringUtils.isNotEmpty(username))
			// {
			// 	if (StringUtils.equals(ipaddr, user.getIpaddr()) && StringUtils.equals(userName, user.getUsername()))
			// 	{
			// 		userOnlineList.add(userOnlineService.selectOnlineByInfo(ipaddr, userName, user));
			// 	}
			// } else
			// {
			// 	userOnlineList.add(userOnlineService.loginUserToUserOnline(user));
			// }
		}
		result.setMsg("查询在线用户成功！");
		result.getData().put("onlineList",onlineList);
		return result;
	}

	/**
	 * 强退用户
	 */
	@DeleteMapping("/{tokenId}")
	public Result forceLogout(@PathVariable String tokenId)
	{
		Result result = new Result();
		//
		return result;
	}
}
