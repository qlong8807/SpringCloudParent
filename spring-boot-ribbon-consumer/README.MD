Ribbon实现客户端负载均衡的方法：
1.服务提供者启动多个实例并注册到一个注册中心，或多个互相关联的注册中心；
2.服务消费者使用被@LoadBalanced修饰过的RestTemplate调用服务接口。

# RestTemplate的可用方法：
## get请求:
*getForEntity*
ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://EUREKA-PROVIDER/user/{1}", User.class,"zhangsan");
Map<String> params = new HashMap<>;
params.put("name","zhangsan");
ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://EUREKA-PROVIDER/user/{name}", User.class,params);
*getForObject*
String forObject = restTemplate.getForObject("http://EUREKA-PROVIDER/user/{1}", String.class, "zhangsan");
## post请求:
restTemplate.postForEntity(url, request, responseType, uriVariables)
restTemplate.postForObject(url, request, responseType, uriVariables)
## put请求
## delete请求






