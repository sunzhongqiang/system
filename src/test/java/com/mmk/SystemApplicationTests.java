package com.mmk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	public static void main(String[] args) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		System.out.println(md5.encodePassword("123456", null));
	}

}
