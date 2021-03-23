package com.dm.dubbo.controller;

import com.dm.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年03月22日 11:31</p>
 * <p>类全名：com.dm.dubbo.controller.TestController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@RestController
public class TestController
{
	@DubboReference()
	TestService testService;

	@GetMapping("/hello")
	public String hello()
	{
		String msg = testService.getTestMsg();
		System.out.println(msg);
		return msg;
	}
}
