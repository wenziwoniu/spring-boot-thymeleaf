package com.vivebest.spring.boot.thymeleaf.service;

import java.util.List;

import com.vivebest.spring.boot.thymeleaf.entity.User;

public interface UserService {
    User findOne(Integer id);

    List<User> find();
}