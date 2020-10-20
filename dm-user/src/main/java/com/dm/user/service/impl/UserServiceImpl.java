package com.dm.user.service.impl;

import com.dm.common.utils.DateUtils;
import com.dm.user.dao.UserDAO;
import com.dm.user.po.User;
import com.dm.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
	UserDAO userDAO;

	@Override
	public List<User> queryList()
	{
		return userDAO.queryList();
	}

	@Override
	public User login(User user)
	{
		User userDB = userDAO.queryUserByUserName(user.getUsername());
		if (userDB != null)
		{
			if (user.getPassword().equals(userDB.getPassword()))
			{
				// 返回时密码置空处理
				userDB.setPassword(null);
				return userDB;
			}
		}
		return null;
	}

	@Override
	public User register(User user)
	{
		User userDB = userDAO.queryUserByUserName(user.getUsername());
		if (userDB != null)
		{
			throw new RuntimeException("用户已存在！");
		}
		// 处理创建时间等字段
		Date serverDate = DateUtils.getServerDate();
		user.setCreatedate(serverDate);
		user.setModifydate(serverDate);
		userDAO.save(user);
		// 返回时密码置空处理
		user.setPassword(null);
		return user;
	}

	@Override
	public void update(User user)
	{
		userDAO.update(user);
	}
	// @Override
	// @Transactional(propagation = Propagation.SUPPORTS)
	// public List<User> findAll()
	// {
	// 	return userDAO.findAll();
	// }
	// @Override
	// public void save(User user)
	// {
	// 	userDAO.save(user);
	// }
	// @Override
	// public void deleteById(int id)
	// {
	// 	userDAO.deleteById(id);
	// }
}
