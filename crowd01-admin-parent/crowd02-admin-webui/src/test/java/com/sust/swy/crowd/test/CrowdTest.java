package com.sust.swy.crowd.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sust.swy.crowd.mapper.AdminMapper;
import com.sust.swy.crowd.service.api.AdminService;
import com.sust.swy.crowd.entity.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml" })
public class CrowdTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testDataSource() throws SQLException {
		// 1.通过数据源对象获取数据源连接
		Connection connection = dataSource.getConnection();
		// 2.打印数据库连接
		System.out.println(connection);
	}

	@Autowired
	private AdminMapper adminMapper;

	@Test
	public void testAdminMapperAutowired() {
		Admin admin = new Admin(null, "tom", "123123", "汤姆", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println(count);
	}
	
	@Test
	public void testLogger() {
		Admin admin = adminMapper.selectByPrimaryKey(1); 
		// 获取日志记录对象 
		Logger logger = LoggerFactory.getLogger(CrowdTest.class); 
		// 按照 Debug 级别打印日志 
		logger.debug(admin.toString());
	}
	
	@Autowired
	AdminService adminService;
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null, "tom", "123123", "汤姆", "tom@qq.com", null);
		adminService.saveAdmin(admin);
	}
}
