package com.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：系统启动类
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月09日 15:06</p>
 * <p>类全名：com.dm.DmApplication</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootApplication
@EnableScheduling	//定时任务
@EnableTransactionManagement	//开启事务
public class DmApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(DmApplication.class, args);
	}
}
