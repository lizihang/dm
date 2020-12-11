package com.dm.user.controller;

import com.dm.common.vo.Result;
import com.dm.log.annotation.DmLog;
import com.dm.user.util.ValidateCodeUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
 * <p>创建日期：2020年10月19日 21:41</p>
 * <p>类全名：com.dm.user.controller.LoginController</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@CrossOrigin //解决跨域问题
@RestController
public class LoginController
{
	/**
	 * 生成验证码
	 */
	@DmLog
	@GetMapping("/getCodeImg")
	public Result getCodeImg(HttpServletResponse response)
	{
		//直接调用静态方法，返回验证码对象
		ValidateCodeUtil.Validate v = ValidateCodeUtil.getRandomCode();
		Map<String,Object> data = new HashMap<>();
		if (v != null)
		{
			data.put("validCode", v.getValue().toLowerCase());
			data.put("validStr", v.getBase64Str());
		}
		return Result.success("获取验证码成功", data);
	}
}
