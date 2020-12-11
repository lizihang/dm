package com.dm.common.vo;

import org.springframework.http.HttpStatus;
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
	private int    status;
	private String msg;
	private Object data;

	private Result()
	{
	}

	private Result(int status, String msg, Object data)
	{
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public static Result success(String msg)
	{
		return success(msg, null);
	}

	public static Result success(String msg, Object data)
	{
		return new Result(HttpStatus.OK.value(), msg, data);
	}

	public static Result error(int errorCode, String msg)
	{
		return error(errorCode, msg, null);
	}

	public static Result error(int errorCode, String msg, Object data)
	{
		return new Result(errorCode, msg, data);
	}
}
