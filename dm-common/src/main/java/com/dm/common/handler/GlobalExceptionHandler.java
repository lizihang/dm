package com.dm.common.handler;

import com.dm.common.exception.DmException;
import com.dm.common.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>标题：全局异常处理</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：异常都抛到controller层，然后通过此处理器统一处理
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月10日 10:21</p>
 * <p>类全名：com.dm.common.handler.GlobalExceptionHandler</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(DmException.class)
	public Result baseException(DmException e)
	{
		logger.error("自定义异常！错误信息：" + e.getMessage());
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}

	/**
	 * 处理空指针的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = NullPointerException.class)
	public Result exceptionHandler(HttpServletRequest req, NullPointerException e)
	{
		logger.error("发生空指针异常！原因是:", e);
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "发生空指针异常！");
	}

	/**
	 * 处理系统内部异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e)
	{
		logger.error("发生空指针异常！原因是:", e);
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "msg");
	}
}
