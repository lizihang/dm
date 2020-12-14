package com.dm.system.config;

import com.dm.system.constants.SystemConstants;
import com.dm.system.handler.LoginFailureHandler;
import com.dm.system.handler.LoginSuccessHandler;
import com.dm.system.handler.LogoutSuccessHandler;
import com.dm.system.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月09日 10:09</p>
 * <p>类全名：com.dm.system.config.SecurityConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Resource(name = UserDetailsServiceImpl.BeanName)
	UserDetailsService userDetailsService;
	/**
	 * 登录成功的处理
	 */
	@Resource
	private LoginSuccessHandler  loginSuccessHandler;
	/**
	 * 登录失败的处理
	 */
	@Resource
	private LoginFailureHandler  loginFailureHandler;
	/**
	 * 登出成功的处理
	 */
	@Resource
	private LogoutSuccessHandler logoutSuccessHandler;

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		// 使用BCrypt加密密码
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.cors().and().csrf().disable();//禁用了 csrf 功能
		// http.authorizeRequests()//限定签名成功的请求
		// 		.antMatchers("/decision/**", "/govern/**", "/employee/*")//
		// 		.hasAnyRole("EMPLOYEE", "ADMIN")//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
		// 		.antMatchers("/employee/login").permitAll()///employee/login 不限定
		// 		.antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
		// 		.antMatchers("/oauth/**").permitAll()//不拦截 oauth 开放的资源
		// 		.anyRequest().permitAll()//其他没有限定的请求，允许访问
		// 		.and().anonymous()//对于没有配置权限的其他请求允许匿名访问
		// 		.and().formLogin()//使用 spring security 默认登录页面
		// 		.and().httpBasic();//启用http 基础验证
		http.authorizeRequests()
				// 放行接口
				.antMatchers(SystemConstants.AUTH_WHITELIST).permitAll()
				// 除上面外的所有请求全部需要鉴权认证
				.anyRequest().authenticated()
				// 异常处理(权限拒绝、登录失效等)
				.and().exceptionHandling()
				// .authenticationEntryPoint(anonymousAuthenticationEntryPoint)//匿名用户访问无权限资源时的异常处理
				// .accessDeniedHandler(accessDeniedHandler)//登录用户没有权限访问资源
				// 登入
				.and().formLogin().permitAll()//允许所有用户
				.loginProcessingUrl("/user/login")//登录请求路径
				.successHandler(loginSuccessHandler)//登录成功处理逻辑
				.failureHandler(loginFailureHandler)//登录失败处理逻辑
				// 登出
				.and().logout().permitAll()//允许所有用户
				.logoutSuccessHandler(logoutSuccessHandler)//登出成功处理逻辑
		// .deleteCookies(RestHttpSessionIdResolver.AUTH_TOKEN)
		// 会话管理
		// .and().sessionManagement().invalidSessionStrategy(invalidSessionHandler) // 超时处理
		// .maximumSessions(1)//同一账号同时登录最大用户数
		// .expiredSessionStrategy(sessionInformationExpiredHandler) // 顶号处理
		;
	}
}
