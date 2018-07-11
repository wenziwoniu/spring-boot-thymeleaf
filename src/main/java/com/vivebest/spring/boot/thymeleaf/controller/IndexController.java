/*@(#)UserController.java   2017年4月27日 
 * Copy Right 2017 Tencent Group Holding Limited.
 * All Copyright Reserved
 */

package com.vivebest.spring.boot.thymeleaf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userservice;
    
    @RequestMapping("index")
    public String index(){
        logger.info("Welcome to index");
        return "index";
    }
    
    @RequestMapping("list")
    public String list(Model model){
        List<User> users = userservice.find();
        
        model.addAttribute("users", users);
        return "userList";
    }
    
    @RequestMapping("detail")
    public String detail(Model model,String id){
        User user = userservice.findOne(Integer.valueOf(id));
        model.addAttribute("user", user);
        return "userDetail";
    }
    
    @RequestMapping("userList_style")
    public String userList_style(Model model){
        List<User> users = userservice.find();
        
        model.addAttribute("users", users);
        return "userList_style";
    }
}
