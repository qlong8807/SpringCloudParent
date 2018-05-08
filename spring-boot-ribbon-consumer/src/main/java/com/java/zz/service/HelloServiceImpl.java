package com.java.zz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HelloServiceImpl implements HelloService {

	private Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Hystrix默认超时时间为2000毫秒。hello服务会随机休眠一段时间。 
	 * Hystrix Command属性：
	 * execution.isolation.strategy,隔离策略，默认THREAD 通过线程池隔离,SEMAPHORE 通过信号量隔离
	 * execution.isolation.thread.timeoutInMilliseconds,方法执行的超时时间，单位为毫秒。
	 * execution.timeout.enabled,是否启用超时，默认true
	 * execution.isolation.thread.interruptOnTimeout,超时是否中断，默认true
	 * 线程池保证不会出现高并发导致无限制占用资源的情况。
	 */
	@Override
	@HystrixCommand(fallbackMethod = "helloFallback",commandProperties= {
			@HystrixProperty(name="execution.timeout.enabled",value="true"),
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
	},threadPoolProperties = {
			@HystrixProperty(name="coreSize",value="20"),
			@HystrixProperty(name="maximumSize",value="50"),
			@HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize",value="true")
	})
	public String getHello(String name) {
		long start = System.currentTimeMillis();
		// EUREKA-PROVIDER是提供者的服务名。
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://EUREKA-PROVIDER/hello/{1}",
				String.class, name);
		long end = System.currentTimeMillis();
		logger.info("远程服务耗时：" + (end - start) + "毫秒");
		logger.info(responseEntity.toString());
		return responseEntity.getBody();
	}

	public String helloFallback(String name) {
		return "can not get rpc method." + name;
	}

}
