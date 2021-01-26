package com.dm.system.aspect;

import com.dm.common.po.BasePO;
import com.dm.common.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;

import java.util.Date;
/**
 * <p>标题：测试切面</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：需要使用时，将类上的注解打开
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月07日 17:31</p>
 * <p>类全名：com.dm.system.aspect.TestDAOAspect</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
// @Aspect
// @Component
public class TestDAOAspect
{

	@Before("execution(* com.dm.*.dao.*.save*(..))")
	public void before(JoinPoint joinPoint) throws IllegalAccessException
	{
		//JoinPoint 通过该对象可以获取到被切入的对象的信息
		Object target = joinPoint.getTarget();//目标对象
		Signature signature = joinPoint.getSignature();//方法签名
		Object[] args = joinPoint.getArgs();//方法参数
		for (Object o : args)
		{
			System.out.println(o.getClass());
			System.out.println(o);
			if (o instanceof BasePO)
			{
				System.out.println("aaa");
				Date date = DateUtils.getServerDate();
				((BasePO) o).setCreateUser("create");
				((BasePO) o).setModifyUser("create");
				((BasePO) o).setCreateDate(date);
				((BasePO) o).setModifyDate(date);

			}
			/*
			Class<?> c = o.getClass();
			Field[] fields = c.getDeclaredFields();
			for (Field f : fields)
			{
				String fName = f.getName();
				if ("createUser".equals(fName) || "modifyUser".equals(fName))
				{
					f.set(o, "aaa");
				}
				if ("createDate".equals(fName) || "modifyDate".equals(fName))
				{
					f.set(o, DateUtils.getServerDate());
				}
			}
			throw new RuntimeException();
			*/
		}
	}
}
