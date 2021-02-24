package com.dm.system.handler;

import com.dm.common.utils.ObjectUtils;
import com.dm.system.utils.JwtTokenUtil;
import com.dm.system.vo.LoginUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
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
 * <p>创建日期：2021年02月21日 14:59</p>
 * <p>类全名：com.dm.system.handler.JwtAuthenticationTokenFilter</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
	@Resource
	JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException
	{
		LoginUser loginUser = jwtTokenUtil.getLoginUser(request);
		if (ObjectUtils.isNotEmpty(loginUser) && ObjectUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication()))
		{
			jwtTokenUtil.validateToken(loginUser);
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		filterChain.doFilter(request, response);
	}
}
