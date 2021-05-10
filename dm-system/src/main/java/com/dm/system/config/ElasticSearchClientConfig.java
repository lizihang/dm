package com.dm.system.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年05月10日 21:09</p>
 * <p>类全名：com.dm.system.config.ElasticSearchClientConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
public class ElasticSearchClientConfig
{
	@Bean
	public RestHighLevelClient restHighLevelClient()
	{
		RestHighLevelClient client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
		return client;
	}
}
