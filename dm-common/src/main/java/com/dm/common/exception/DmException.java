package com.dm.common.exception;

/**
 * <p>标题：通用异常类</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月09日 15:12</p>
 * <p>类全名：com.dm.common.exception.DmException</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DmException extends RuntimeException
{
	private static final long serialVersionUID = 1663117985895236825L;

	public DmException()
	{
	}

	public DmException(String message)
	{
		super(message);
	}

	public DmException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DmException(Throwable cause)
	{
		super(cause);
	}

	public DmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
