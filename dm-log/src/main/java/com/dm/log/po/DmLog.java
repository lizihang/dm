package com.dm.log.po;

import com.dm.po.BasePO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
/**
 * <p>标题：日志对象</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月03日 15:35</p>
 * <p>类全名：com.dm.log.po.DmLog</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DmLog extends BasePO
{
	private static final long   serialVersionUID = 5142476744976867392L;
	/**id*/
	private              int    id;
	/**用户名*/
	private              String username;
	/**方法*/
	private              String method;
	/**备注*/
	private              String remark;
	/**日志类型*/
	private              String logtype;
	/**操作时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private              Date   operatetime;

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

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getLogtype()
	{
		return logtype;
	}

	public void setLogtype(String logtype)
	{
		this.logtype = logtype;
	}

	public Date getOperatetime()
	{
		return operatetime;
	}

	public void setOperatetime(Date operatetime)
	{
		this.operatetime = operatetime;
	}

	@Override
	public String toString()
	{
		return "DmLog{" + "id=" + id + ", username='" + username + '\'' + ", method='" + method + '\'' + ", remark='" + remark + '\'' + ", logtype='" + logtype + '\'' + ", operatetime=" + operatetime + "} " + super.toString();
	}
}
