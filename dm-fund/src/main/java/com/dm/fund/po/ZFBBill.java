package com.dm.fund.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
/**
 * <p>标题：支付宝账单对象</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月21日 17:41</p>
 * <p>类全名：com.dm.fund.po.ZFBBill</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class ZFBBill extends Bill
{
	private static final long       serialVersionUID = -6412701611707028481L;
	/** 商家订单号 */
	private              String     orderCode;
	/** 交易创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private              Date       tradeCreateTime;
	/** 交易修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private              Date       tradeModifyTime;
	/** 交易来源地 */
	private              String     tradeSourc;
	/** 类型(即时到账交易,支付宝担保交易) */
	private              String     type;
	/** 服务费（元） */
	private              BigDecimal serviceFund;
	/** 成功退款（元） */
	private              BigDecimal refund;
	/** 资金状态 */
	private              String     fundStatus;

	public String getOrderCode()
	{
		return orderCode;
	}

	public void setOrderCode(String orderCode)
	{
		this.orderCode = orderCode;
	}

	public Date getTradeCreateTime()
	{
		return tradeCreateTime;
	}

	public void setTradeCreateTime(Date tradeCreateTime)
	{
		this.tradeCreateTime = tradeCreateTime;
	}

	public Date getTradeModifyTime()
	{
		return tradeModifyTime;
	}

	public void setTradeModifyTime(Date tradeModifyTime)
	{
		this.tradeModifyTime = tradeModifyTime;
	}

	public String getTradeSourc()
	{
		return tradeSourc;
	}

	public void setTradeSourc(String tradeSourc)
	{
		this.tradeSourc = tradeSourc;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public BigDecimal getServiceFund()
	{
		return serviceFund;
	}

	public void setServiceFund(BigDecimal serviceFund)
	{
		this.serviceFund = serviceFund;
	}

	public BigDecimal getRefund()
	{
		return refund;
	}

	public void setRefund(BigDecimal refund)
	{
		this.refund = refund;
	}

	public String getFundStatus()
	{
		return fundStatus;
	}

	public void setFundStatus(String fundStatus)
	{
		this.fundStatus = fundStatus;
	}
}
