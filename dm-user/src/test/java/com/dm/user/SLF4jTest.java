package com.dm.user;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月23日 23:10</p>
 * <p>类全名：com.dm.user.SLF4jTest</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootTest
public class SLF4jTest
{
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void TestLogger()
	{
		// 日志级别从低到高trace -> debug -> info -> warn -> error
		logger.trace("trace");
		logger.debug("debug");
		// SpringBoot默认info级别
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}
