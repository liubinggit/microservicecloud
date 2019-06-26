package com.lb.springcloud.service.impl;

import com.lb.springcloud.dao.UserDao;
import com.lb.springcloud.entities.User;
import com.lb.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public boolean add(User user) {
        return dao.addUser(user);
    }

    @Override
    public User get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<User> list() {
        return dao.findAll();
    }
}
