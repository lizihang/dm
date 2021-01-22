package com.dm.poi;

import com.dm.fund.po.Bill;
import com.dm.fund.po.ZFBBill;
import com.dm.fund.service.BillService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月22日 14:08</p>
 * <p>类全名：com.dm.poi.CsvTest</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootTest
public class CsvTest
{
	@Resource
	BillService billService;

	@Test
	void testCsv() throws IOException, InvocationTargetException, IllegalAccessException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\JetBrains\\IntelliJ IDEA Project\\dm\\dm-system\\src\\main\\resources\\file\\bill.csv"), "GBK");
		CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(isr);
		Map<String,Integer> headerMap = csvParser.getHeaderMap();
		int count = 0;
		List<Bill> data = new ArrayList<>();
		for (CSVRecord csvRecord : csvParser)
		{
			// 新建对象
			ZFBBill bill = new ZFBBill();
			// 将数据转换成对象，放入list
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
				//TODO
				dataMap.put("", value);
				System.out.println(key + ":" + value);
			}
			BeanUtils.populate(bill, dataMap);
			// 对象放入list
			data.add(bill);
			count++;
			// 每500条存入数据库
			if (count % 500 == 0)
			{
				//TODO billService.insert(data);
				data.clear();
			}
		}
		System.out.println("数据导入成功，总共导入" + count + "条数据");
	}
}
