package com.dm.fund.dao;

import com.dm.fund.po.Bill;
import com.dm.fund.vo.BillQueryParams;
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
 * <p>创建日期：2021年01月21日 18:56</p>
 * <p>类全名：com.dm.fund.dao.BillDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface BillDAO
{
	List<Bill> queryList(BillQueryParams params);

	int insertList(List<Bill> data);
}
