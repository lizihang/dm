package com.dm.common.constants;

/**
 * <p>标题：Http状态码</p>
 * <p>功能：</p>
 * <pre>
 * 其他说明：
 * 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
 * 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
 * 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
 * 204 NO CONTENT - [DELETE]：用户删除数据成功。
 * 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
 * 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
 * 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
 * 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
 * 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
 * 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
 * 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
 * 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
 * </pre>
 * <p>作者：lizh</p>
 * <p>审核：</p>
 * <p>重构：</p>
 * <p>创建日期：2020年12月09日 17:27</p>
 * <p>类全名：com.dm.common.constants.HttpStatus</p>
 * 查看帮助：<a href="" target="_blank"></a>
 */
public class HttpStatus
{
	/**
	 * [GET]：服务器成功返回用户请求的数据
	 */
	public static final int OK                  = 200;
	/**
	 * [POST/PUT/PATCH]：用户新建或修改数据成功
	 */
	public static final int CREATED             = 201;
	/**
	 * [*]：表示一个请求已经进入后台排队（异步任务）
	 */
	public static final int ACCEPTED            = 202;
	/**
	 * [DELETE]：用户删除数据成功。
	 */
	public static final int NO_CONTENT          = 204;
	/**
	 * [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作
	 */
	public static final int INVALID_REQUEST     = 400;
	/**
	 * [*]：表示用户没有权限（令牌、用户名、密码错误）
	 */
	public static final int UNAUTHORIZED        = 401;
	/**
	 * [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的
	 */
	public static final int FORBIDDEN           = 403;
	/**
	 * [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作
	 */
	public static final int NOT_FOUND           = 404;
	/**
	 * [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）
	 */
	public static final int NOT_ACCEPTABLE      = 406;
	/**
	 * [GET]：用户请求的资源被永久删除，且不会再得到的
	 */
	public static final int GONE                = 410;
	/**
	 * [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误
	 */
	public static final int UNPROCESABLE_ENTITY = 422;
	/**
	 * [*]：服务器发生错误，用户将无法判断发出的请求是否成功
	 */
	public static final int ERROR               = 500;
}
