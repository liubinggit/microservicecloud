package com.lb.springcloud.service;

import com.lb.springcloud.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-USER")
public interface DeptClientService {

    @PostMapping("/user/add")
    public boolean add(User user);

    @GetMapping("/user/get/{id}")
    public User get(@PathVariable("id") Long id);

    @GetMapping("/user/list")
    public List<User> list();

}
