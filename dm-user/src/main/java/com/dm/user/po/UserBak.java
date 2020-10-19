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
 * <p>创建日期：2020年10月19日 21:57</p>
 * <p>类全名：com.dm.user.po.UserBak</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class UserBak
{
	private int    id;
	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date   birth;
	private String gender;
	private String addr;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getAddr()
	{
		return addr;
	}

	public void setAddr(String addr)
	{
		this.addr = addr;
	}

	@Override
	public String toString()
	{
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", birth=" + birth + ", gender='" + gender + '\'' + ", addr='" + addr + '\'' + '}';
	}
}
