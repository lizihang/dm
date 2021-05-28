package com.dm.system.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.system.po.Dict;
import com.dm.system.po.DictInfo;
import com.dm.system.service.SysService;
import com.dm.system.vo.DmDictQueryParams;
import com.dm.system.vo.Menus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>标题：系统相关功能Controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * 功能：
 * 1.系统菜单的增删改查
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年11月10日 9:45</p>
 * <p>类全名：com.dm.system.controller.SysController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("system")
public class SysController
{
	private static final Logger logger = LoggerFactory.getLogger(SysController.class);
	@Resource
	SysService sysService;

	/**
	 * 验证token
	 * @return
	 */
	@DmLog
	@GetMapping("checkToken")
	public Result checkToken()
	{
		return Result.success("验证token通过");
	}

	/**
	 * 获取系统菜单
	 * @return
	 */
	@DmLog
	@GetMapping("getMenus")
	public Result getMenus()
	{
		List<Menus> menus = sysService.getMenus();
		return Result.success("获取系统菜单成功！", menus);
	}

	/**
	 * 获取字典列表
	 * @return
	 */
	@DmLog
	@GetMapping("queryDictList")
	public Result queryDictList(DmDictQueryParams params)
	{
		Map<String,Object> data = new HashMap<>();
		data.put("list", sysService.queryDictList(params));
		data.put("total", sysService.queryDictTotal(params));
		return Result.success("查询字典列表成功", data);
	}

	/**
	 * 获取字典信息
	 * @return
	 */
	@DmLog
	@GetMapping("queryDictInfo")
	public Result queryDictInfo(@RequestParam String dictId)
	{
		List<DictInfo> data = sysService.queryDictInfo(dictId);
		return Result.success("查询字典信息成功", data);
	}

	/**
	 * 新增字典
	 * @return
	 */
	@DmLog
	@PostMapping("addDict")
	public Result addDict(@RequestBody Dict dict)
	{
		sysService.addDict(dict);
		return Result.success("新增字典成功");
	}

	/**
	 * 修改字典
	 * @return
	 */
	@DmLog
	@PostMapping("updateDict")
	public Result updateDict(@RequestBody Dict dict)
	{
		sysService.updateDict(dict);
		return Result.success("修改字典成功");
	}

	@DmLog
	@DeleteMapping("deleteDict/{dictId}")
	public Result deleteDict(@PathVariable("dictId") String dictId)
	{
		sysService.deleteDict(dictId);
		return Result.success("删除字典编号<" + dictId + ">的字典成功！");
	}

	@DmLog
	@PostMapping("updateAvatar")
	public Result updateAvatar(@RequestParam("avatar") MultipartFile file)
	{
		if (!file.isEmpty())
		{
			String fileName = file.getOriginalFilename();
			int size = (int) file.getSize();
			System.out.println(fileName + "-->" + size);
			String path = "D:/dm/upload/avatar";
			String username = "admin";
			File dest = new File(path + "/" + username + "/" + fileName);
			if (!dest.getParentFile().exists())
			{
				//判断文件父目录是否存在
				boolean success = dest.getParentFile().mkdirs();
				if (success)
				{
					logger.info("创建目录成功！" + dest.getAbsolutePath());
				} else
				{
					logger.error("创建目录失败！" + dest.getAbsolutePath());
				}
			}
			try
			{
				file.transferTo(dest); //保存文件
				return Result.success("文件上传成功", username + "/" + fileName);
			} catch (IllegalStateException | IOException e)
			{
				e.printStackTrace();
			}
		}
		return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "上传文件不能为空！");
	}
}
