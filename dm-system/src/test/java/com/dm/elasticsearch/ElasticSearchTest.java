package com.dm.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.dm.po.ESUser;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：elasticsearch相关测试类
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年05月10日 21:22</p>
 * <p>类全名：com.dm.elasticsearch.ElasticSearchTest</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootTest
public class ElasticSearchTest
{
	@Autowired
	RestHighLevelClient restHighLevelClient;

	/**
	 * 测试创建索引
	 */
	@Test
	void testCreateIndex()
	{
		CreateIndexRequest request = new CreateIndexRequest("test");
		try
		{
			CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
			System.out.println(createIndexResponse);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 测试获取索引
	 */
	@Test
	void testGetIndex()
	{
		GetIndexRequest request = new GetIndexRequest("test");
		try
		{
			GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
			System.out.println(Arrays.toString(getIndexResponse.getIndices()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 测试删除索引
	 */
	@Test
	void testDeleteIndex()
	{
		DeleteIndexRequest request = new DeleteIndexRequest("test");
		try
		{
			AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
			System.out.println(delete.isAcknowledged());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 测试添加文档
	 */
	@Test
	void testAddDocument()
	{
		ESUser user = new ESUser("knight", 18);
		IndexRequest request = new IndexRequest("test");
		request.id("1");
		request.timeout();
		request.source(JSON.toJSONString(user), XContentType.JSON);
		try
		{
			IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
			System.out.println(response.toString());
			System.out.println(response.status());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 测试获取文档
	 */
	@Test
	void testGetDocument()
	{
		GetRequest request = new GetRequest("test", "1");
		try
		{
			GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
			System.out.println(response.getSourceAsString());
			System.out.println(response);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateDocument()
	{
		UpdateRequest request = new UpdateRequest("test", "1");
		request.timeout();
		ESUser user = new ESUser("knight", 20);
		request.doc(JSON.toJSONString(user), XContentType.JSON);
		try
		{
			UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
			System.out.println(response.status());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	void testDeleteDocument()
	{
		DeleteRequest request = new DeleteRequest("test", "1");
		try
		{
			DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
			System.out.println(response.status());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 批量插入数据
	 */
	@Test
	void testB()
	{
		// TODO
	}

	/**
	 * 搜索
	 */
	@Test
	void testSearch()
	{
		SearchRequest request = new SearchRequest("test");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "knight");
		searchSourceBuilder.query(termQueryBuilder);
		searchSourceBuilder.timeout();
		request.source(searchSourceBuilder);
		try
		{
			SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
			System.out.println(JSON.toJSONString(response.getHits()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
