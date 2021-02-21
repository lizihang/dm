package com.dm.fund.controller;

import com.dm.common.vo.Result;
import com.dm.fund.constants.BillConstants;
import com.dm.fund.po.Bill;
import com.dm.fund.po.ZFBBill;
import com.dm.fund.service.BillService;
import com.dm.fund.vo.BillQueryParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
/**
 * <p>标题：账单controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月21日 17:57</p>
 * <p>类全名：com.dm.fund.controller.BillController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("bill")
public class BillController
{
	@Resource
	BillService billService;

	/**
	 * 查询账单信息
	 * @return
	 */
	@GetMapping("queryList")
	public Result queryList(BillQueryParams params) throws IllegalAccessException, InvocationTargetException, InstantiationException
	{
		List<? extends Bill> bills;
		if (params.getBillType().equals(BillConstants.BILL_TYPE_ZFB))
		{
			bills = billService.queryList(params, ZFBBill.class);
		} else
		{
			bills = billService.queryList(params, Bill.class);
		}
		return Result.success("查询账单成功！", bills);
	}
}
