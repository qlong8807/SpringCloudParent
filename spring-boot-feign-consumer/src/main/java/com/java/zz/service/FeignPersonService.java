package com.java.zz.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="eureka-provider",fallback=FeignPersonServiceFallback.class)
public interface FeignPersonService extends PersonService{

}
