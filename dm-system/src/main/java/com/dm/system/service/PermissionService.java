package com.dm.system.service;

import com.dm.common.utils.StringUtils;
import com.dm.system.vo.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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
 * <p>创建日期：2020年12月09日 16:15</p>
 * <p>类全名：com.dm.system.service.PermissionService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service("ps")
public class PermissionService
{
	/**
	 * 验证用户是否具备某权限
	 *
	 * @param permission 权限字符串
	 * @return 用户是否具备某权限
	 */
	public boolean permission(String permission)
	{
		if (StringUtils.isEmpty(permission))
		{
			return false;
		}
		// TODO
		// LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
		LoginUser loginUser = new LoginUser();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		GrantedAuthority grantedAuthority1 = new SimpleGrantedAuthority("system:job:query");
		GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority("system:job:add");
		grantedAuthorities.add(grantedAuthority1);
		grantedAuthorities.add(grantedAuthority2);
		loginUser.setAuthorities(grantedAuthorities);
		if (ObjectUtils.isEmpty(loginUser) || CollectionUtils.isEmpty(loginUser.getAuthorities()))
		{
			return false;
		}
		for (GrantedAuthority auth : loginUser.getAuthorities())
		{
			if (permission.matches(auth.getAuthority()))
			{
				return true;
			}
		}
		return false;
	}
}
