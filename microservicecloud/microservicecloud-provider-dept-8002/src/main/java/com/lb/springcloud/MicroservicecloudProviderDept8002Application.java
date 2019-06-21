package com.lb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //本服务启动后自动注册进eureka
@EnableDiscoveryClient  //服务发现
@SpringBootApplication
public class MicroservicecloudProviderDept8002Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudProviderDept8002Application.class, args);
	}

}
