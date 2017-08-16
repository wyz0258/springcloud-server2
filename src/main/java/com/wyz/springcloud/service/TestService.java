package com.wyz.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/13
 */
@FeignClient("compute-service")
public interface TestService {

    @RequestMapping(method = RequestMethod.GET, value = "/del")
    int del(Integer a,Integer b);
}
