package com.dm.system.aspect;

import com.dm.common.exception.DmException;
import com.dm.common.po.BasePO;
import com.dm.common.util.RedisUtil;
import com.dm.common.utils.DateUtils;
import com.dm.system.constants.SystemConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
/**
 * <p>标题：BasePO默认值处理</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * 1、拦截save*方法，给创建人，创建时间，修改人，修改时间赋值
 * 2、拦截update*方法，给修改人，修改时间赋值
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月08日 10:25</p>
 * <p>类全名：com.dm.system.aspect.BasePODefaultValueAspect</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Aspect
@Component
public class BasePODefaultValueAspect
{
	@Resource
	RedisUtil redisUtil;

	@Before("execution(* com.dm.*.dao.*.save*(..))")
	public void beforeSave(JoinPoint joinPoint) throws IllegalAccessException
	{
		Object[] args = joinPoint.getArgs();
		for (Object o : args)
		{
			if (o instanceof BasePO)
			{
				setCreateValue(o);
			}
		}
	}

	@Before("execution(* com.dm.*.dao.*.update*(..))")
	public void beforeUpdate(JoinPoint joinPoint) throws IllegalAccessException
	{
		Object[] args = joinPoint.getArgs();
		for (Object o : args)
		{
			if (o instanceof BasePO)
			{
				setModifyValue(o);
			}
		}
	}

	/**
	 * 设置创建人，创建时间
	 * @param o
	 */
	private void setCreateValue(Object o)
	{
		Date date = DateUtils.getServerDate();
		((BasePO) o).setCreateUser(getLoginUser());
		((BasePO) o).setCreateDate(date);
	}

	/**
	 * 设置修改人，修改时间
	 * @param o
	 */
	private void setModifyValue(Object o)
	{
		Date date = DateUtils.getServerDate();
		((BasePO) o).setModifyUser(getLoginUser());
		((BasePO) o).setModifyDate(date);
	}

	/**
	 * 获取当前登录用户
	 * @return
	 */
	private String getLoginUser()
	{
		Object value = redisUtil.get(SystemConstants.REDIS_KEY_LOGIN_USER);
		if (value == null)
		{
			throw new DmException(SystemConstants.ERR_CODE_00);
		}
		return value.toString();
	}
}
