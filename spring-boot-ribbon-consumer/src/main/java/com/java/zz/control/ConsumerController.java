package com.java.zz.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.zz.service.HelloService;

@RestController
public class ConsumerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="consum",method=RequestMethod.GET)
	public String consum() {
		//EUREKA-PROVIDER是提供者的服务名。
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://EUREKA-PROVIDER/hello", String.class);
		logger.info(responseEntity.toString());
		return responseEntity.getBody();
	}
	
	@GetMapping("/gethello/{name}")
	public String getHello(@PathVariable("name") String uname) {
		return helloService.getHello(uname);
	}
}
