package com.dm.fund.po;

import com.dm.common.po.BasePO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
/**
 * <p>标题：基础账单对象</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年01月21日 17:21</p>
 * <p>类全名：com.dm.fund.po.Bill</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class Bill extends BasePO
{
	private static final long       serialVersionUID = -4738578812315818660L;
	/** id */
	private              int        id;
	/** 账号 */
	private              String     userCode;
	/** 交易号 */
	private              String     tradeCode;
	/** 交易方向(收/支) */
	private              String     tradeDirection;
	/** 商品名称 */
	private              String     goods;
	/** 金额（元） */
	private              BigDecimal amount;
	/** 付款时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private              Date       paymentTime;
	/** 交易对方 */
	private              String     toUserCode;
	/** 交易状态 */
	private              String     status;
	/** 账单类型(支付宝/微信/信用卡/储蓄卡) */
	private              String     billType;
	/** 备注 */
	private              String     remark;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getTradeCode()
	{
		return tradeCode;
	}

	public void setTradeCode(String tradeCode)
	{
		this.tradeCode = tradeCode;
	}

	public String getTradeDirection()
	{
		return tradeDirection;
	}

	public void setTradeDirection(String tradeDirection)
	{
		this.tradeDirection = tradeDirection;
	}

	public String getGoods()
	{
		return goods;
	}

	public void setGoods(String goods)
	{
		this.goods = goods;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	public Date getPaymentTime()
	{
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime)
	{
		this.paymentTime = paymentTime;
	}

	public String getToUserCode()
	{
		return toUserCode;
	}

	public void setToUserCode(String toUserCode)
	{
		this.toUserCode = toUserCode;
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

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	@Override
	public String toString()
	{
		return "Bill{" + "id=" + id + ", userCode='" + userCode + '\'' + ", tradeCode='" + tradeCode + '\'' + ", tradeDirection='" + tradeDirection + '\'' + ", goods='" + goods + '\'' + ", amount=" + amount + ", paymentTime=" + paymentTime + ", toUserCode='" + toUserCode + '\'' + ", status='" + status + '\'' + ", billType='" + billType + '\'' + ", remark='" + remark + '\'' + "} " + super.toString();
	}
}
