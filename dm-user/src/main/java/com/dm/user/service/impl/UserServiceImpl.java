package com.dm.user.service.impl;

import com.dm.common.constants.Constants;
import com.dm.common.util.RedisCache;
import com.dm.common.utils.DateUtils;
import com.dm.user.dao.UserDAO;
import com.dm.user.po.DmUser;
import com.dm.user.service.UserService;
import com.dm.user.vo.DmUserQueryParams;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月13日 17:05</p>
 * <p>类全名：com.dm.user.service.impl.UserServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Resource
	UserDAO         userDAO;
	@Resource
	PasswordEncoder passwordEncoder;
	@Resource
	RedisCache      redisCache;

	@Override
	public List<DmUser> queryList(DmUserQueryParams params)
	{
		return userDAO.queryList(params);
	}

	@Override
	public DmUser queryUserByUserName(String username)
	{
		String key = Constants.USER_KEY + username;
		// 1.从缓存中查询数据
		if (redisCache.hasKey(key))
		{
			System.out.println("redis");
			return redisCache.getCacheObject(key);
		}
		// 2.缓存中不存在，则查询数据库
		DmUser user = userDAO.queryUserByUserName(username);
		if (user != null)
		{
			// 3.将对象存入缓存
			// TODO 查询数据库中不存在的数据，会有缓存穿透问题，布隆过滤器
			redisCache.setCacheObject(key, user);
		} else
		{
			// 临时用这种方法解决
			redisCache.setCacheObject(key, user, 600, TimeUnit.SECONDS);
		}
		System.out.println("mybatis");
		return user;
	}

	@Override
	public void register(DmUser user)
	{
		DmUser userDB = userDAO.queryUserByUserName(user.getUsername());
		if (userDB != null)
		{
			throw new RuntimeException("用户已存在！");
		}
		//TODO 密码应该前端也加密
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		// 处理创建人，创建时间字段
		Date serverDate = DateUtils.getServerDate();
		user.setCreateDate(serverDate);
		user.setCreateUser(user.getUsername());
		userDAO.save(user);
	}

	@Override
	public void updateUser(DmUser user)
	{
		// TODO 修改为更新有值字段
		if (user.getPassword() != null)
		{
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		userDAO.update(user);
	}

	@Override
	public void deleteUserByLogic(int id)
	{
		DmUser user = new DmUser();
		user.setId(id);
		user.setStatus(Constants.STATUS_DELETE);
		userDAO.update(user);
	}

	@Override
	public void deleteUserById(int id)
	{
		userDAO.deleteById(id);
	}
}
