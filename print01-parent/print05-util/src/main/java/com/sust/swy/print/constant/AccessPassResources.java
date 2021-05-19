package com.sust.swy.print.constant;

import java.util.HashSet;
import java.util.Set;

public class AccessPassResources {

	public static final Set<String> PASS_RES_SET = new HashSet<>();

	static {
		PASS_RES_SET.add("/");
		PASS_RES_SET.add("/to/admin/login/page");
		PASS_RES_SET.add("/admin/loginout");
		PASS_RES_SET.add("/admin/do/login.html");
		PASS_RES_SET.add("/to/merchant/login/page");
		PASS_RES_SET.add("/merchant/loginout");
		PASS_RES_SET.add("/to/member/register/page");
		PASS_RES_SET.add("/to/member/login/page");
		PASS_RES_SET.add("/member/loginout");
	}

	public static final Set<String> STATIC_RES_SET = new HashSet<>();

	static {
		STATIC_RES_SET.add("bootstrap");
		STATIC_RES_SET.add("css");
		STATIC_RES_SET.add("fonts");
		STATIC_RES_SET.add("img");
		STATIC_RES_SET.add("jquery");
		STATIC_RES_SET.add("layer");
		STATIC_RES_SET.add("script");
		STATIC_RES_SET.add("ztree");
	}

	/***
	 * 用于判断某个 ServletPath 值是否对应一个静态资源
	 * 
	 * @param servletPath
	 * @return true：是静态资源 * false：不是静态资源
	 */
	public static boolean judgeCurrentServletPathWetherStaticResource(String servletPath) {
		if (servletPath == null || servletPath.length() == 0) {
			throw new RuntimeException(PrintConstant.MESSAGE_STRING_INVALIDATE);
		}
		String[] split = servletPath.split("/");
		String firstLevelPath = split[1];
		return STATIC_RES_SET.contains(firstLevelPath);
	}

}
