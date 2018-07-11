
package com.vivebest.spring.boot.thymeleaf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivebest.spring.boot.thymeleaf.dao.UserDao;
import com.vivebest.spring.boot.thymeleaf.entity.User;
import com.vivebest.spring.boot.thymeleaf.service.UserService;

@Service("com.vivebest.spring.boot.thymeleaf.service.UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> find() {
        return userDao.find();
    }
}