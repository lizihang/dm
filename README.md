#一个前后端分离的学习项目

## 一、SpringBoot整合swagger3

### 1.增加pom
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

### 2.增加配置类
```java
@EnableOpenApi
@Configuration
public class SwaggerConfig
{
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dm"))
				.build();
	}

	private ApiInfo apiInfo()
	{
		Contact contact = new Contact("dm", "www.dm.com", "dm@163.com");
		return new ApiInfo(
				"学习swagger3",
				"swagger3描述",
				"v1.0",
				"www.dm.com",
				contact,
				"Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<>());
	}
}
```

### 3.SpringSecurity放行相关资源
```text
"/swagger-ui/**",
"/v3/**",
"/swagger-resources/**"
```

### 4.根据环境配置是否启用swagger
在swagger配置类中，Docket中增加enable方法
```text
@Bean
public Docket docket(Environment env)
{
    //获取项目环境
    Profiles profiles = Profiles.of("dev");
    //判断项目是否处于此环境下
    boolean flag = env.acceptsProfiles(profiles);
    return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .enable(flag)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dm"))
            .build();
}
```

### 5.访问路径
http://localhost:8081/swagger-ui/index.html


## 二、SpringBoot整合swagger2

### 1.增加pom
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```

### 2.增加配置类
```java
@EnableSwagger2
@Configuration
public class SwaggerConfig
{
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dm"))
				.build();
	}

	private ApiInfo apiInfo()
	{
		Contact contact = new Contact("dm", "www.dm.com", "dm@163.com");
		return new ApiInfo(
				"学习swagger3",
				"swagger3描述",
				"v1.0",
				"www.dm.com",
				contact,
				"Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<>());
	}
}
```

### 3.SpringSecurity放行相关资源
```text
"/swagger-ui.html",
"/webjars/**",
"/v2/**",
"/swagger-resources/**"
```

### 4.根据环境配置是否启用swagger
与swagger3配置方法相同

### 5.访问路径
http://localhost:8081/swagger-ui.html


## 三、SpringBoot整合druid

### 1.增加pom
```xml
<!-- 使用这个替代druid 可以简化druid配置，application.yml中可以用spring.datasource.druid.xxx直接配置 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>${druid.version}</version>
</dependency>
```

### 2.TODO

## 四、SpringBoot整合MyBatis

## 五、SpringBoot整合SpringSecurity

## 六、SpringBoot整合Quartz

## 七、SpringBoot整合Redis

## 八、SpringBoot整合Slf4j