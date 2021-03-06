package com.dm.system.param;

import com.dm.common.vo.QueryParams;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年06月08日 19:03</p>
 * <p>类全名：com.dm.system.param.DmUserQueryParams</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DmUserQueryParams extends QueryParams
{
	private static final long    serialVersionUID = 1889549005275678384L;
	/** 用户名 */
	private              String  username;
	/** 昵称 */
	private              String  nickname;
	/** 邮箱 */
	private              String  email;
	/** 状态 */
	private              Integer status;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
}
