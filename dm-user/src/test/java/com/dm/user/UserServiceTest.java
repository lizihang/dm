package com.dm.user;

import com.dm.user.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
/**
 * <p>标题：</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年10月13日 15:48</p>
 * <p>类全名：com.dm.user.UserServiceTest</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
@SpringBootTest
public class UserServiceTest
{
	@Resource
	private UserService userService;

	/*
	@Test
	public void testFindAll()
	{
		List<User> all = userService.findAll();
		for (User user : all)
		{
			System.out.println(user);
		}
	}

	@Test
	public void testSave()
	{
		User user = new User();
		user.setName("管理员");
		user.setGender("男");
		user.setBirth(new Date());
		user.setAddr("北京市西城区");
		userService.save(user);
	}

	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(1);
		user.setName("管理员");
		user.setGender("男");
		user.setBirth(new Date());
		user.setAddr("北京市西城区");
		userService.update(user);
	}

	@Test
	public void testDeleteById()
	{
		userService.deleteById(4);
	}
	*/
}
