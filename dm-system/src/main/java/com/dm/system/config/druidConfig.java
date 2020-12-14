package com.dm.system.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月14日 10:58</p>
 * <p>类全名：com.dm.system.config.druidConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
public class druidConfig
{
	@Value("${spring.datasource.druid.loginUsername}")
	private String loginUsername;
	@Value("${spring.datasource.druid.loginPassword}")
	private String loginPassword;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean statViewServlet()
	{
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");//处理drueuid下的所有请求
		Map<String,String> initParams = new HashMap<>();
		initParams.put("loginUsername", loginUsername);//用户名
		initParams.put("loginPassword", loginPassword);//密码
		initParams.put("allow", "127.0.0.1");//白名单，允许ip访问
		initParams.put("deny", "192.168.0.1");//黑名单，拒绝ip访问，黑名单优先于白名单
		initParams.put("resetEnable", "false");//是否能够重置数据 禁用HTML页面上的“Reset All”功能
		bean.setInitParameters(initParams);
		return bean;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean webStatFilter()
	{
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String,String> initParams = new HashMap<>();
		initParams.put("exclusions", "*.js,*.css,/druid/*");//静态资源放行
		bean.setInitParameters(initParams);
		bean.setUrlPatterns(Collections.singletonList("/*"));
		return bean;
	}
}
