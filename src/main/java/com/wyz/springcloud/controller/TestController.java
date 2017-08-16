package com.wyz.springcloud.controller;

import common.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/13
 */

@RestController
@Slf4j
public class TestController {

//    private static Logger log = LoggerFactory.getLogger(TestController.class);

//    @Autowired
//    TestService testService;

    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();


        Integer r = a + b;
        log.error(1+"1");
        log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @RequestMapping(value = "/del" ,method = RequestMethod.GET)
    public Integer del(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();

        Integer r = a + b;
        log.info("/del, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    @RequestMapping(value = "/obj" ,method = RequestMethod.GET)
    public TestModel obj(@RequestParam Integer a, @RequestParam Integer b, @RequestParam String c) {
        ServiceInstance instance = client.getLocalServiceInstance();

        Integer r = a + b;
        log.info("/obj, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        TestModel model = new TestModel();
        model.setA(a);
        model.setB(b);
        model.setC(c);
        log.info("/obj, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + model.toString());
        return model;
    }




}
