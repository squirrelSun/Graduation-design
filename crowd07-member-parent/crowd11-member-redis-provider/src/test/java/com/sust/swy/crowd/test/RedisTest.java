package com.sust.swy.crowd.test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testSet() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set("apple", "red");
	}

	@Test
	public void testExSet() {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set("banana", "yellow", 5000, TimeUnit.MINUTES);
	}

	@Test
	public void testLock() {
		System.out.println("-----尝试加锁-----");
		System.out.println("-----释放锁资源-----");
	}
	
}
