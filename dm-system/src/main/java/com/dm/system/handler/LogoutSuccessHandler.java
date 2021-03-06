package com.dm.system.handler;

import com.dm.common.constants.Constants;
import com.dm.common.util.RedisCache;
import com.dm.common.vo.Result;
import com.dm.system.util.JwtTokenUtil;
import com.dm.system.util.ServletUtil;
import com.dm.system.constants.SystemConstants;
import com.dm.system.vo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * <p>创建日期：2020年12月09日 15:58</p>
 * <p>类全名：com.dm.system.handler.LogoutSuccessHandler</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler
{
	@Resource
	RedisCache   redisCache;
	@Resource
	JwtTokenUtil jwtTokenUtil;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{
		// TODO 登出成功 记录登出日志
		// 1.登出成功，删除缓存
		LoginUser loginUser = jwtTokenUtil.getLoginUser(request);
		redisCache.deleteObject(SystemConstants.LOGIN_USER_KEY + loginUser.getUsername());
		redisCache.deleteObject(Constants.USER_KEY + loginUser.getUsername());
		// TODO 用户<%s>退出登录
		ServletUtil.render(response, Result.success("退出登录成功！"));
	}
}
