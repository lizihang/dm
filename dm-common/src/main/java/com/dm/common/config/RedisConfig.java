package com.dm.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月09日 16:05</p>
 * <p>类全名：com.dm.common.config.RedisConfig</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Configuration
public class RedisConfig
{
	@Bean
	@SuppressWarnings("all")
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory)
	{
		RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
		template.setConnectionFactory(factory);
		// Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// jackson2JsonRedisSerializer.setObjectMapper(om);
		serializer.setObjectMapper(om);
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		// key采用String的序列化方式
		template.setKeySerializer(stringRedisSerializer);
		// hash的key也采用String的序列化方式
		template.setHashKeySerializer(stringRedisSerializer);
		// value序列化方式采用jackson
		// template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setValueSerializer(serializer);
		// hash的value序列化方式采用jackson
		// template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.setHashValueSerializer(serializer);
		template.afterPropertiesSet();
		return template;
	}
}
