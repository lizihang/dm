package com.dm.fund.vo;

import com.dm.common.vo.QueryParams;

import java.util.Date;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月21日 19:01</p>
 * <p>类全名：com.dm.fund.vo.BillQueryParams</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class BillQueryParams extends QueryParams
{
	private static final long   serialVersionUID = -4859617658671953031L;
	/** 账号 */
	private              String userCode;
	/** 交易方向(收/支) */
	private              String tradeDirection;
	/** 付款时间 */
	private              Date   paymentTime;
	/** 状态 */
	private              String status;
	/** 账单类型 */
	private              String billType;

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getTradeDirection()
	{
		return tradeDirection;
	}

	public void setTradeDirection(String tradeDirection)
	{
		this.tradeDirection = tradeDirection;
	}

	public Date getPaymentTime()
	{
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime)
	{
		this.paymentTime = paymentTime;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getBillType()
	{
		return billType;
	}

	public void setBillType(String billType)
	{
		this.billType = billType;
	}
}
