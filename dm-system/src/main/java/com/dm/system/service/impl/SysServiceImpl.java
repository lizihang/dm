package com.dm.system.service.impl;

import com.dm.common.exception.DmException;
import com.dm.common.util.StrUtil;
import com.dm.system.dao.SysDAO;
import com.dm.system.po.Dict;
import com.dm.system.po.DictInfo;
import com.dm.system.service.SysService;
import com.dm.system.vo.DmDictQueryParams;
import com.dm.system.vo.Menus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
 * <p>创建日期：2020年11月10日 9:45</p>
 * <p>类全名：com.dm.system.service.impl.SysServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service
public class SysServiceImpl implements SysService
{
	@Resource
	SysDAO sysDAO;

	@Override
	public List<Menus> getMenus()
	{
		return sysDAO.getMenus();
	}

	@Override
	public List<Dict> queryDictList(DmDictQueryParams params)
	{
		return sysDAO.queryDictList(params);
	}

	@Override
	public Object queryDictTotal(DmDictQueryParams params)
	{
		return sysDAO.queryDictTotal(params);
	}

	@Override
	public List<DictInfo> queryDictInfo(String dictId)
	{
		if (StrUtil.isEmpty(dictId)){
			throw new DmException("字典id不能为空！");
		}
		return sysDAO.queryDictInfo(dictId);
	}

	@Override
	public void addDict(Dict dict)
	{
		sysDAO.addDict(dict);
	}

	@Override
	public void updateDict(Dict dict)
	{
		sysDAO.updateDict(dict);
	}
}
