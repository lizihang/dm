package com.dm.fund.service.impl;

import com.dm.common.util.DateConverter;
import com.dm.fund.constants.BillConstants;
import com.dm.fund.dao.BillDAO;
import com.dm.fund.po.Bill;
import com.dm.fund.po.CreditCardBill;
import com.dm.fund.po.WXBill;
import com.dm.fund.po.ZFBBill;
import com.dm.fund.service.BillService;
import com.dm.fund.vo.BillQueryParams;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
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

	@Override
	public int insertList(List<Bill> data)
	{
		return billDAO.insertList(data);
	}

	@Override
	public void importCsv(String filePath, String userCode, String billType) throws IOException, InvocationTargetException, IllegalAccessException
	{
		ConvertUtils.register(new DateConverter(), Date.class);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "GBK");
		CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(isr);
		Map<String,Integer> headerMap = csvParser.getHeaderMap();
		int count = 0;
		List<Bill> data = new ArrayList<>();
		for (CSVRecord csvRecord : csvParser)
		{
			// 1.新建对象
			Bill bill = new ZFBBill();
			switch (billType)
			{
			case BillConstants.BILL_TYPE_ZFB:
				bill = new ZFBBill();
				break;
			case BillConstants.BILL_TYPE_WX:
				bill = new WXBill();
				break;
			case BillConstants.BILL_TYPE_CREDIC:
				bill = new CreditCardBill();
				break;
			//TODO
			case BillConstants.BILL_TYPE_TODO:
				break;
			}
			// 2.将数据转换成对象
			Map<String,Object> dataMap = new HashMap<>();
			for (String key : headerMap.keySet())
			{
				String value = "";
				if (csvRecord.get(key) == null || csvRecord.get(key).trim().length() == 0)
				{
					value = null;
				} else
				{
					value = csvRecord.get(key).trim();
				}
				dataMap.put(key, value);
				System.out.println(key + ":" + value);
			}
			BeanUtils.populate(bill, dataMap);
			// 10:支付宝
			bill.setUserCode(userCode);
			bill.setBillType(billType);
			// 3.对象放入list
			data.add(bill);
			count++;
			// 4.每500条存入数据库
			if (count % 500 == 0)
			{
				billDAO.insertList(data);
				data.clear();
			}
		}
		// 5.最后不够500的再执行insert
		billDAO.insertList(data);
		System.out.println("数据导入成功，总共导入" + count + "条数据");
	}
}
