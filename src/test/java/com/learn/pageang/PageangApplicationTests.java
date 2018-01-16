package com.learn.pageang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
//@TestPropertySource(locations={"classpath:application.properties","classpath:application-test.properties"})
public class PageangApplicationTests {

	@Test
	public void contextLoads() {
	}

}
