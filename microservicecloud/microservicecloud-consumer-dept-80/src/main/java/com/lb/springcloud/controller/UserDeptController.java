package com.lb.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lb.springcloud.entities.Dept;
import com.lb.springcloud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserDeptController {

    private static final String USER_REST_URL_PREFIX = "http://MICROSERVICECLOUD-USER";
    private static final String DEPT_REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept_user/add", method = RequestMethod.POST)
    public boolean add()
    {
        User user = new User();
        user = user.setName("aa").setAge(66);
        Dept dept = new Dept();
        dept = dept.setDeptName("testDept");
        boolean userFlag = restTemplate.postForObject(USER_REST_URL_PREFIX+"/user/add", user, Boolean.class);
        boolean deptFlag = restTemplate.postForObject(DEPT_REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
        System.out.println("userFlag:"+userFlag);
        System.out.println("deptFlag:"+deptFlag);
        return true;
    }
}
