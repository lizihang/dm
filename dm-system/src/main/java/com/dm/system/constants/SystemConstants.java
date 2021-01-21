package com.dm.system.constants;

/**
 * <p>标题：常量类</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月08日 10:42</p>
 * <p>类全名：com.dm.system.constants.SystemConstants</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class SystemConstants
{
	/**==================== Redis常用key ====================*/
	public static final String REDIS_KEY_LOGIN_USER = "user";

	/**
	 * 登录用户 redis key
	 */
	public static final String LOGIN_TOKEN_KEY = "login_tokens:";

	/**==================== 错误吗 ====================*/
	public static final String ERR_CODE_00 = "当前登录用户不存在！请检查";

	/**==================== 不需要权限的 ====================*/
	public static final String[] AUTH_WHITELIST = {
			//登录相关
			"/getCodeImg",
			"/user/login",
			"/user/register",
			//swagger3相关
			"/swagger-ui/**",
			"/v3/**",
			"/swagger-resources/**"
			//swagger2相关
			// "/swagger-ui.html",
			// "/webjars/**",
			// "/v2/**",
			// "/swagger-resources/**"
			};

}
