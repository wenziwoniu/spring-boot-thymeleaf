/*@(#)UserController.java   2017年4月27日 
 * Copy Right 2017 Tencent Group Holding Limited.
 * All Copyright Reserved
 */

package com.vivebest.spring.boot.thymeleaf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivebest.spring.boot.thymeleaf.entity.User;
import com.vivebest.spring.boot.thymeleaf.service.UserService;

/**
 * 用户查询接口
 * <p>
 * 
 * @version 1.0.0,2017年4月27日
 * @author zhengzhangwen
 * @since 1.0.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userservice;

    @RequestMapping("/findOne")
    public User findOne(String id) {
        logger.info("findOne by id:{}",id);
        return userservice.findOne(Integer.valueOf(id));
    }
    
    @RequestMapping("/find")
    public List<User> find() {

        return userservice.find();
    }
}
