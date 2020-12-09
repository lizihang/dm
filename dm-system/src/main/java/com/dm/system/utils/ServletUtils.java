package com.dm.system.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月09日 15:41</p>
 * <p>类全名：com.dm.system.utils.ServletUtils</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class ServletUtils
{
	/**
	 * 渲染到客户端
	 * @param response
	 * @param object 待渲染的实体类，会自动转为json
	 * @throws IOException
	 */
	public static void render(HttpServletResponse response, Object object) throws IOException
	{
		// 允许跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 允许自定义请求头token(允许head跨域)
		response.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.getWriter().print(JSON.toJSONString(object));
	}
}
