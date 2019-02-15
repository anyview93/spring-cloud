package com.mine.serviceribbon.service.impl;

import com.mine.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author shizhiguo
 * @ClassName HelloServiceImpl
 * @date 2019-02-15
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String helloService(String name) {
        return restTemplate.getForObject("http://EURKA-CLIENT/hello?name=" + name, String.class);
    }
}
