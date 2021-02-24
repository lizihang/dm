package com.dm.user.dao;

import com.dm.user.po.DmRole;
import com.dm.user.vo.DmRoleQueryParams;
import org.apache.ibatis.annotations.Mapper;

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
 * <p>创建日期：2021年02月24日 15:52</p>
 * <p>类全名：com.dm.user.dao.RoleDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface RoleDAO
{
	List<DmRole> queryList(DmRoleQueryParams params);

	void save(DmRole role);

	void update(DmRole role);

	void deleteById(int id);
}
