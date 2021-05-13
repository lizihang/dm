package com.dm.user.service;

import com.dm.user.po.DmUser;
import com.dm.user.vo.DmUserQueryParams;

import java.util.List;
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
	 * 查询所有用户
	 * @return 用户列表
	 */
	List<DmUser> queryList(DmUserQueryParams params);

	/**
	 * 查询总数量
	 * @return
	 */
	int queryTotal(DmUserQueryParams params);

	/**
	 * 根据用户名查找
	 * @return 用户对象
	 */
	DmUser queryUserByUserName(String username);

	/**
	 * 用户注册
	 * @param user 用户
	 */
	void register(DmUser user);

	/**
	 * 用户修改
	 * @param user 用户
	 */
	void updateUser(DmUser user);

	/**
	 * 逻辑删除
	 * @param id
	 */
	void deleteUserByLogic(int id);

	/**
	 * 根据用户id删除用户
	 * @param id id
	 */
	void deleteUserById(int id);
}
