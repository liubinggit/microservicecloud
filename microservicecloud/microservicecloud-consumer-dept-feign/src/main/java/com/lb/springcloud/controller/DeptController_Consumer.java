package com.lb.springcloud.controller;

import com.lb.springcloud.entities.Dept;
import com.lb.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer
{
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return deptClientService.add(dept);
    }

    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return deptClientService.list();
    }

//    @GetMapping("/consumer/dept/discovery")
//    public Object discovery() {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//    }
}

