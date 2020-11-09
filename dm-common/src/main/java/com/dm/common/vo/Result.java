package com.dm.common.vo;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>标题：通用结果类</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月09日 15:11</p>
 * <p>类全名：com.dm.common.vo.Result</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class Result
{
	private boolean            status;
	private String             msg;
	private Map<String,Object> data;

	public Result()
	{
		this.status = true;
	}

	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public Map<String,Object> getData()
	{
		return data = data == null ? new HashMap<>() : data;
	}

	public void setData(Map<String,Object> data)
	{
		this.data = data;
	}
}
