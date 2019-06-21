package com.lb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicecloudProviderDeptHystrix8001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudProviderDeptHystrix8001Application.class, args);
	}

}
