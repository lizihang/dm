package com.dm.user.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
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
public class User
{
	private int    id;
	private String username;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date   createdate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date   modifydate;

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

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}

	public Date getModifydate()
	{
		return modifydate;
	}

	public void setModifydate(Date modifydate)
	{
		this.modifydate = modifydate;
	}

	@Override
	public String toString()
	{
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", createdate=" + createdate + ", modifydate=" + modifydate + '}';
	}
}
