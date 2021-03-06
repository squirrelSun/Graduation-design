package com.sust.swy.crowd.handler;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sust.swy.crowd.util.ResultEntity;

@RestController
public class RedisHandler {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@RequestMapping("/set/redis/key/value/remote")
	ResultEntity<String> setRedisKeyValueRemote(@RequestParam("key") String key, @RequestParam("value") String value) {
		try {
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/set/redis/key/value/remote/with/timeout")
	ResultEntity<String> setRedisKeyValueRemoteWithTimeout(@RequestParam("key") String key,
			@RequestParam("value") String value, @RequestParam("time") long time,
			@RequestParam("timeUnit") TimeUnit timeUnit) {
		try {
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			operations.set(key, value, time, timeUnit);
			return ResultEntity.successWithoutData(); 
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/get/redis/string/value/by/key")
	ResultEntity<String> getRedisStringValueByKeyRemote(@RequestParam("key") String key) {
		try {
			ValueOperations<String, String> operations = redisTemplate.opsForValue();
			String value = operations.get(key);
			return ResultEntity.successWithData(value);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/remove/redis/key/remote")
	ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key) {
		try {
			redisTemplate.delete(key);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}
	
	@RequestMapping("/lock/key")
	void lockKey(@RequestParam("key")String key) {
		System.out.println("-----尝试加锁-----");
		System.out.println("-----锁超时，自动解锁-----");
	}
	
	@RequestMapping("/unlock/key")
	void unlockKey(@RequestParam("key")String key) {
		System.out.println("-----尝试加锁-----");
		System.out.println("-----释放锁资源-----");
	}
	
}
