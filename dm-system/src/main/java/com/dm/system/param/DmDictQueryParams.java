package com.dm.system.param;

import com.dm.common.vo.QueryParams;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2021年05月17日 16:11</p>
 * <p>类全名：com.dm.system.param.DmDictQueryParams</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class DmDictQueryParams extends QueryParams
{
	private static final long    serialVersionUID = 7648547050562742213L;
	/** 字典id */
	private              String  dictId;
	/** 字典名称 */
	private              String  dictName;
	/** 状态 */
	private              Integer status;

	public String getDictId()
	{
		return dictId;
	}

	public void setDictId(String dictId)
	{
		this.dictId = dictId;
	}

	public String getDictName()
	{
		return dictName;
	}

	public void setDictName(String dictName)
	{
		this.dictName = dictName;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
}
