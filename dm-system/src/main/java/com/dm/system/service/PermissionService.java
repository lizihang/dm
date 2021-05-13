package com.dm.system.service;

import com.dm.common.constants.Constants;
import com.dm.common.util.StrUtil;
import com.dm.system.util.JwtTokenUtil;
import com.dm.system.util.ServletUtil;
import com.dm.system.vo.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
	@Resource
	JwtTokenUtil tokenUtil;

	/**
	 * 验证用户是否具备某权限
	 *
	 * @param permission 权限字符串
	 * @return 用户是否具备某权限
	 */
	public boolean permission(String permission)
	{
		// 系统选项，是否检查权限，不检查返回true
		if (!Constants.IS_CHECK_PERMISSION)
		{
			return true;
		}
		if (StrUtil.isEmpty(permission))
		{
			return false;
		}
		HttpServletRequest request = ServletUtil.getRequest();
		String requestURI = request.getRequestURI();
		LoginUser loginUser = tokenUtil.getLoginUser(request);
		if (ObjectUtils.isEmpty(loginUser) || CollectionUtils.isEmpty(loginUser.getAuthorities()))
		{
			return false;
		}
		for (GrantedAuthority auth : loginUser.getAuthorities())
		{
			// if (permission.matches(auth.getAuthority()))
			// {
			// 	return true;
			// }
			if (requestURI.matches(auth.getAuthority()))
			{
				return true;
			}
		}
		return false;
	}
}
