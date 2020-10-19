package com.dm.user.service;

import com.dm.user.po.User;
/**
 * <p>标题：用户service</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：处理用户登录，用户注册，用户修改
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月13日 17:05</p>
 * <p>类全名：com.dm.user.service.UserService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface UserService
{
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 用户注册
	 * @param user
	 */
	void regist(User user);

	/**
	 * 用户修改
	 * @param user
	 */
	void update(User user);
	// List<User> findAll();
	// void save(User user);
	// void deleteById(int id);
}
