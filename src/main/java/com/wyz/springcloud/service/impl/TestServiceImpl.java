package com.wyz.springcloud.service.impl;

import com.wyz.springcloud.service.TestService;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/14
 */
public class TestServiceImpl implements TestService {
    @Override
    public int del(Integer a, Integer b) {
        return a+b;
    }
}
