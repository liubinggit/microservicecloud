package com.lb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lb.springcloud"})
@ComponentScan("com.lb.springcloud")
public class MicroservicecloudConsumerDeptFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudConsumerDeptFeignApplication.class, args);
	}

}
