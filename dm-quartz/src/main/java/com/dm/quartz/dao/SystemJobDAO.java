package com.dm.quartz.dao;

import com.dm.quartz.po.SystemJob;
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
 * <p>创建日期：2020年11月20日 15:24</p>
 * <p>类全名：com.dm.quartz.dao.SystemJobDAO</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@Mapper
public interface SystemJobDAO
{
	/**
	 * 查询所有任务
	 * @return
	 */
	List<SystemJob> queryList();

	/**
	 * 根据条件查找任务列表
	 * @param systemJob
	 * @return
	 */
	List<SystemJob> selectJobList(SystemJob systemJob);

	/**
	 * 根据id查询任务
	 * @param id
	 */
	SystemJob queryJobById(int id);

	/**
	 * 新增任务
	 * @param systemJob
	 * @return
	 */
	int save(SystemJob systemJob);

	/**
	 * 修改任务
	 * @param systemJob
	 * @return
	 */
	int updateJob(SystemJob systemJob);

	/**
	 * 删除任务
	 * @param jobId
	 * @return
	 */
	int deleteJobById(int jobId);
}
