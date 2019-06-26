package com.lb.springcloud.controller;

import com.lb.springcloud.entities.User;
import com.lb.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    @Autowired
    private UserService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public boolean add(@RequestBody User user)
    {
        return service.add(user);
    }

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list(){
        return service.list();
    }

    @GetMapping("/user/discovery")
    public Object discovery() {
        List<String> services = client.getServices();
        System.out.println("**************"+services);

        List<ServiceInstance> serverList = client.getInstances("MICROSERVICECLOUD-USER");
        for (ServiceInstance serveice:serverList) {
            System.out.println(serveice.getServiceId() +" "+serveice.getHost()+" "+serveice.getPort()+" "+serveice.getUri());
        }
        return this.client;
    }
}
