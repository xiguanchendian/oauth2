package com.xgcd.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/viewer")
public class ViewerTestController {


    // 返回ModelAndView对象
    @RequestMapping(value = "/hellomv", method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("hello");// hello, null!
    }

    // 返回页面名
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";// hello, springboot-thymeleaf!
    }

    // 返回页面名
    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "page/helloWorld";// helloWorld!
    }

}
