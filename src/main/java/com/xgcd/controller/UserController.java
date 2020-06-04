package com.xgcd.controller;

import com.xgcd.entity.User;
import com.xgcd.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserServiceI userService;

    @RequestMapping("/users")
//    @ResponseBody
    public String getUserList(ModelMap map) {
        List<User> users = userService.selectUserList();
        map.put("users", users);
//        return "index";
        return users.toString();
    }

    @RequestMapping("/user/{id}")
//    @ResponseBody
    public String getUser(@PathVariable int id){
        User user = userService.selectUserById(id);
        return user.toString();
    }
}
