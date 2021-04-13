package com.sust.swy.crowd.test;

import org.junit.Test;

import com.sust.swy.crowd.util.CrowdUtil;

public class StringMd5Test {

	@Test
	public void test() {
		String a = "123123";
		String md5 = CrowdUtil.md5(a);
		System.out.println(md5);
	}
	
}
