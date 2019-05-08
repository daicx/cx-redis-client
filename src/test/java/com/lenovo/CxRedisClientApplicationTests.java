package com.lenovo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lenovo.client.CxClient;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CxRedisClientApplicationTests {

	@Test
	public void contextLoads() {
	}
	@SuppressWarnings("resource")
	@Test
	public void JedisTest() {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("dcx", "12");
	}
	@Test
	public void CxRedisClientTest() {
		try {
			CxClient cxClient = new CxClient("", 6379);
			cxClient.set("dcx", "12");
			cxClient.get("dcx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
