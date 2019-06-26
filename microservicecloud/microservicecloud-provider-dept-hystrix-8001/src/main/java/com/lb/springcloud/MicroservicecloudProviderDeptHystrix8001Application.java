package com.lb.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@EnableEurekaClient
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicecloudProviderDeptHystrix8001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicecloudProviderDeptHystrix8001Application.class, args);
	}


	@Bean
	public ServletRegistrationBean getServlet(){

		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();

		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

		registrationBean.setLoadOnStartup(1);

		registrationBean.addUrlMappings("/actuator/hystrix.stream");

		registrationBean.setName("HystrixMetricsStreamServlet");


		return registrationBean;
	}

}
