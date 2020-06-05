package com.xgcd.scope;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope(value = "prototype")
@RequestMapping("/mvcController")
public class SpringMvcControllerScope {
    private static int st = 0;// 静态的
    private int index = 0;// 非静态的

    // 创建ThreadLocal变量
    ThreadLocal<Integer> localVariable = new ThreadLocal<>();

    @RequestMapping("/test")
    public String test() {
        System.out.println(st++ + "|" + index++);
        return "index";
    }

    @RequestMapping("/threadLocal")
    public String threadLocal() {
        localVariable.set(index++);
        Integer result = localVariable.get();
        System.out.println("threadLocal:" + result);
        return "index";
    }

}
