package com.lb.springcloud.service;

import com.lb.springcloud.entities.User;

import java.util.List;

public interface UserService
{
    public boolean add(User user);

    public User get(Long id);

    public List<User> list();
}
