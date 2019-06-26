package com.lb.springcloud.controller;

import com.lb.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController_Consumer
{
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-USER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/user/add")
    public boolean add(User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/user/add", user, Boolean.class);
    }

    @RequestMapping(value="/consumer/user/get/{id}")
    public User get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id, User.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/user/list")
    public List<User> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/user/list", List.class);
    }

    @GetMapping("/consumer/user/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/discovery", Object.class);
    }
}

