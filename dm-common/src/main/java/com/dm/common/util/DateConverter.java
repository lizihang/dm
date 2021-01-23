package com.dm.common.util;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * 解决apache commons beanUtils时间类型转换报错
 * org.apache.commons.beanutils.ConversionException: DateConverter does not support default String to 'Date' conversion
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月22日 23:17</p>
 * <p>类全名：com.dm.common.util.DateConverter</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DateConverter implements Converter
{
	@Override
	public <T> T convert(Class<T> aClass, Object value)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		if (value == null)
		{
			return null;
		} else if (value instanceof String)
		{
			String str = ((String) value).replace("/", "-");
			try
			{
				date = sdf.parse(str);
				return (T) date;
			} catch (ParseException e)
			{
				try
				{
					date = sdf2.parse(str);
					return (T) date;
				} catch (ParseException ex)
				{
					//e.printStackTrace();
					System.out.println("====================");
					System.out.println(value);
					System.out.println("====================");
				}
			}
		} else
		{
			return null;
		}
		return null;
	}
}
