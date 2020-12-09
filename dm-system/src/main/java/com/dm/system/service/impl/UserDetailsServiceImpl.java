package com.dm.system.service.impl;

import com.dm.common.utils.DateUtils;
import com.dm.system.vo.LoginUser;
import com.dm.user.po.User;
import com.dm.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
 * <p>创建日期：2020年12月09日 10:20</p>
 * <p>类全名：com.dm.system.service.impl.UserDetailsServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service(UserDetailsServiceImpl.BeanName)
public class UserDetailsServiceImpl implements UserDetailsService
{
	public static final  String BeanName = "UserDetailsService";
	private static final Logger logger   = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Resource
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		User user = userService.queryUserByUserName(username);
		if (user == null)
		{
			logger.info("登录用户：{} 不存在.", username);
			throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
		return createLoginUser(user);
	}

	public UserDetails createLoginUser(User user)
	{
		//TODO 做个util转换对象？
		return new LoginUser(user, DateUtils.getServerDate(), "127.0.0.1");
	}
}
