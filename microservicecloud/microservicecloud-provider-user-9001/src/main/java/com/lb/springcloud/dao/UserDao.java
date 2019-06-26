package com.lb.springcloud.dao;

import com.lb.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao
{
    public boolean addUser(User user);

    public User findById(Long id);

    public List<User> findAll();
}