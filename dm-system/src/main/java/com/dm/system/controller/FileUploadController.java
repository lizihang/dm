package com.dm.system.controller;

import com.dm.common.vo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/**
 * <p>标题：文件上传controller</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月23日 16:03</p>
 * <p>类全名：com.dm.system.controller.FileUploadController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin
@RestController
@RequestMapping("file")
public class FileUploadController
{
	private String folder = "E:/Test/";

	/**
	 * 文件上传
	 * @return
	 */
	//@DmLog 特殊参数 日志注解会报错
	@PostMapping("upload")
	public Result fileUpload(@RequestParam("file") MultipartFile file)
	{
		try
		{
			byte[] bytes = file.getBytes();
			Path path = Paths.get(folder + System.currentTimeMillis() + "-" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return Result.success("文件上传成功");
	}

	/**
	 * 多文件上传
	 * @return
	 */
	//@DmLog 特殊参数 日志注解会报错
	@PostMapping("uploads")
	public Result fileUploads(@RequestParam("files") List<MultipartFile> files) throws IOException
	{
		for (MultipartFile file : files)
		{
			String fileName = file.getOriginalFilename();
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			String fName = System.currentTimeMillis() + suffixName;
			File dest = new File(folder + fName);
			file.transferTo(dest);
		}
		return Result.success("文件上传成功");
	}
}
