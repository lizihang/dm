package com.dm.common.vo;

import org.springframework.http.HttpStatus;

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
	private int            status;
	private String             msg;
	private Map<String,Object> data;

	public Result()
	{
		this(HttpStatus.OK.value());
	}

	public Result(int status)
	{
		this(status,null);
	}

	public Result(int status, String msg)
	{
		this.status = status;
		this.msg = msg;
	}

	public int isStatus()
	{
		return status;
	}

	public void setStatus(int status)
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

	/**
	 * 建议使用getData.put方式
	 * @param data
	 */
	@Deprecated
	public void setData(Map<String,Object> data)
	{
		this.data = data;
	}
}
