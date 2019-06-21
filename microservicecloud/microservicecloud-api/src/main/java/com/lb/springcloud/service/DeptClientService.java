package com.lb.springcloud.service;

import com.lb.springcloud.entities.Dept;
import com.lb.springcloud.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    public boolean add(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> list();

}
