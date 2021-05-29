package com.dm.user.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.dm.common.po.BasePO;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年02月23日 11:16</p>
 * <p>类全名：com.dm.user.po.DmUser</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DmUser extends BasePO
{
	private static final long   serialVersionUID = 5591750859687447212L;
	/** id */
	private              int    id;
	/** 用户名 */
	private              String username;
	/** 密码 */
	@JSONField(serialize = false)
	private              String password;
	/** 昵称 */
	private              String nickname;
	/** 邮箱 */
	private              String email;
	/** 性别 */
	private              int    gender;
	/** 状态 */
	private              String status;

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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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

	public int getGender()
	{
		return gender;
	}

	public void setGender(int gender)
	{
		this.gender = gender;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "DmUser{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", nickname='" + nickname + '\'' + ", email='" + email + '\'' + ", gender=" + gender + ", status='" + status + '\'' + "} " + super.toString();
	}
}
