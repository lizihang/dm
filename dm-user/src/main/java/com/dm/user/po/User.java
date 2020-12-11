package com.dm.user.po;

import com.dm.po.BasePO;

import javax.validation.constraints.NotNull;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月13日 17:03</p>
 * <p>类全名：com.dm.user.po.User</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class User extends BasePO
{
	private static final long   serialVersionUID = -3231453355270971403L;
	/**id*/
	private              int    id;
	/**用户名*/
	@NotNull
	private              String username;
	/**昵称*/
	private              String nickname;
	/**密码*/
	private              String password;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", nickname='" + nickname + '\'' + ", password='" + password + '\'' + "} " + super.toString();
	}
}
