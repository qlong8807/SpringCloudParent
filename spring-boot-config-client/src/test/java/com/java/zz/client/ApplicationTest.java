package com.java.zz.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void testContextLoads() {
		assertThat(this.ctx).isNotNull();
//		assertThat(this.ctx.containsBean("MessageController")).isTrue();
//		assertThat(this.ctx.containsBean("ConfigClientApplication")).isTrue();
//		assertThat(this.ctx.containsBean("sampleSimpleApplication")).isTrue();
}

}
