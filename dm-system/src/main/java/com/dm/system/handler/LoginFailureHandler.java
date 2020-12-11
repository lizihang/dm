package com.dm.system.handler;

import com.dm.common.vo.Result;
import com.dm.system.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

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
 * <p>创建日期：2020年12月09日 15:47</p>
 * <p>类全名：com.dm.system.handler.LoginFailureHandler</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler
{
	Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
	{
		Result result;
		String username = request.getRemoteUser();
		if (exception instanceof AccountExpiredException)
		{
			// 账号过期
			logger.info("[登录失败] - 用户[{}]账号过期", username);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 用户账号过期");
		} else if (exception instanceof BadCredentialsException)
		{
			// 密码错误
			logger.info("[登录失败] - 用户[{}]密码错误", username);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 用户密码错误");
		} else if (exception instanceof CredentialsExpiredException)
		{
			// 密码过期
			logger.info("[登录失败] - 用户[{}]密码过期", username);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 用户密码过期");
		} else if (exception instanceof DisabledException)
		{
			// 用户被禁用
			logger.info("[登录失败] - 用户[{}]被禁用", username);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 用户被禁用");
		} else if (exception instanceof LockedException)
		{
			// 用户被锁定
			logger.info("[登录失败] - 用户[{}]被锁定", username);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 用户被锁定");
		} else if (exception instanceof InternalAuthenticationServiceException)
		{
			// 内部错误
			logger.error(String.format("[登录失败] - [%s]内部错误", username), exception);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 内部错误");
		} else
		{
			// 其他错误
			logger.error(String.format("[登录失败] - [%s]其他错误", username), exception);
			result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "[登录失败] - 其他错误");
		}
		// TODO 登录失败 记录日志
		ServletUtils.render(response, result);
	}
}
