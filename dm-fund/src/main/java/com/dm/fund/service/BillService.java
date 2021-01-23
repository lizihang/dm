package com.dm.fund.service;

import com.dm.fund.po.Bill;
import com.dm.fund.vo.BillQueryParams;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
 * <p>创建日期：2021年01月21日 17:58</p>
 * <p>类全名：com.dm.fund.service.BillService</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public interface BillService
{
	List<Bill> queryList(BillQueryParams params);

	int insertList(List<Bill> data);

	void importCsv(String filePath, String userCode, String billType) throws IOException, InvocationTargetException, IllegalAccessException;
}
