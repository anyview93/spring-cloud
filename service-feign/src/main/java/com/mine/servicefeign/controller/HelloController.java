package com.mine.servicefeign.controller;

import com.mine.servicefeign.service.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shizhiguo
 * @ClassName HelloController
 * @date 2019-02-17
 */
@RestController
public class HelloController {

    @Autowired
    SchedualServiceHello schedualServiceHello;

    @GetMapping(value = "hello")
    public String hello(@RequestParam String name) {
        return schedualServiceHello.sayHelloFromClientOne(name);
    }
}
