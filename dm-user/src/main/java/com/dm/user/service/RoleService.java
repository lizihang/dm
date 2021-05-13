package com.dm.user.service;

import com.dm.user.po.DmRole;
import com.dm.user.vo.DmRoleQueryParams;

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
 * <p>创建日期：2021年02月24日 15:45</p>
 * <p>类全名：com.dm.user.service.RoleService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface RoleService
{
	/**
	 * 查询所有角色
	 * @return 用户列表
	 */
	List<DmRole> queryList(DmRoleQueryParams params);

	/**
	 * 查询总数量
	 * @param params
	 * @return
	 */
	int queryTotal(DmRoleQueryParams params);

	/**
	 * 新增角色
	 * @param role 角色
	 */
	void addRole(DmRole role);

	/**
	 * 更新角色
	 * @param role 角色
	 */
	void updateRole(DmRole role);

	/**
	 * 逻辑删除
	 * @param id
	 */
	void deleteRoleByLogic(int id);

	/**
	 * 根据用户id删除用户
	 * @param id id
	 */
	void deleteRoleById(int id);


}
