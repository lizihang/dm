package com.dm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年03月22日 11:34</p>
 * <p>类全名：com.dm.DmDubboConsumerApplication</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootApplication
@EnableDubbo
public class DmDubboConsumerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DmDubboConsumerApplication.class, args);
	}
}
