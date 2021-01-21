package com.dm.fund.service.impl;

import com.dm.fund.dao.BillDAO;
import com.dm.fund.po.Bill;
import com.dm.fund.service.BillService;
import com.dm.fund.vo.BillQueryParams;
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
 * <p>创建日期：2021年01月21日 18:56</p>
 * <p>类全名：com.dm.fund.service.impl.BillServiceImpl</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Service
public class BillServiceImpl implements BillService
{
	@Resource
	BillDAO billDAO;

	@Override
	public List<Bill> queryList(BillQueryParams params)
	{
		return billDAO.queryList(params);
	}
}
