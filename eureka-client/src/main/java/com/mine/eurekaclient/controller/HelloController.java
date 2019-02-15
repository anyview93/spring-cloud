package com.mine.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shizhiguo
 * @ClassName HelloController
 * @date 2019-02-15
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name, HttpServletRequest request){
        int port = request.getServerPort();
        String str = "hello " + name + ", i am from port " + port;
        return str;
    }
}
