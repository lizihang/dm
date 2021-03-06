package com.dm.system.dao;

import com.dm.system.po.DmUser;
import com.dm.system.param.DmUserQueryParams;
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
 * <p>创建日期：2021年06月08日 19:02</p>
 * <p>类全名：com.dm.system.dao.UserDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface UserDAO
{
	List<DmUser> queryList(DmUserQueryParams params);

	int queryTotal(DmUserQueryParams params);

	DmUser queryUserByUserName(String username);

	void save(DmUser user);

	void update(DmUser user);

	void deleteById(int id);
}
