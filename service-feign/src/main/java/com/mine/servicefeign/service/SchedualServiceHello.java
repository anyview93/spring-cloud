package com.mine.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shizhiguo
 * @ClassName SchedualServiceHello
 * @date 2019-02-17
 */
@FeignClient(value = "eurka-client")
public interface SchedualServiceHello {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);
}
