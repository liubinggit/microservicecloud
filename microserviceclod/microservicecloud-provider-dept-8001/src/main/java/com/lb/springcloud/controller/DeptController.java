package com.lb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.lb.springcloud.entities.Dept;
import com.lb.springcloud.service.DeptService;

@RestController
public class DeptController{

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("**************"+services);

        List<ServiceInstance> serverList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance serveice:serverList) {
            System.out.println(serveice.getServiceId() +" "+serveice.getHost()+" "+serveice.getPort()+" "+serveice.getUri());
        }
        return this.client;
    }
}
