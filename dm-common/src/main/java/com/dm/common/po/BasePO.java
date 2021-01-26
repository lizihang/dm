package com.dm.common.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
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
 * <p>创建日期：2021年01月26日 10:49</p>
 * <p>类全名：com.dm.common.po.BasePO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class BasePO implements Serializable
{
	private static final long   serialVersionUID = -9053633431591965726L;
	/** 创建人 */
	private              String createUser;
	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private              Date   createDate;
	/** 修改人 */
	private              String modifyUser;
	/** 修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private              Date   modifyDate;

	public String getCreateUser()
	{
		return createUser;
	}

	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getModifyUser()
	{
		return modifyUser;
	}

	public void setModifyUser(String modifyUser)
	{
		this.modifyUser = modifyUser;
	}

	public Date getModifyDate()
	{
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate)
	{
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString()
	{
		return "BasePO{" + "createUser='" + createUser + '\'' + ", createDate=" + createDate + ", modifyUser='" + modifyUser + '\'' + ", modifyDate=" + modifyDate + '}';
	}
}
