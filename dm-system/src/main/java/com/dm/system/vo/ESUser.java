package com.dm.system.vo;

import org.springframework.stereotype.Component;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：elasticsearch学习用的user类
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年05月10日 22:03</p>
 * <p>类全名：com.dm.system.vo.ESUser</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Component
public class ESUser
{
	private String name;
	private int    age;

	public ESUser()
	{
	}

	public ESUser(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
