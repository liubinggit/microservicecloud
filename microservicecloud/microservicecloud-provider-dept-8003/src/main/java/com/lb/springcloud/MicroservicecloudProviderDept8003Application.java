package com.lb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后自动注册进eureka
@EnableDiscoveryClient  //服务发现
public class MicroservicecloudProviderDept8003Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudProviderDept8003Application.class, args);
	}

}
