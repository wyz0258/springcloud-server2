package com.wyz.springcloud.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/8/11
 */
@Component
public class TaskUtil {


    /**
     * 定时任务
     * 每3秒执行一次
     */
    @Scheduled(fixedRate = 3000)
    public void testTask(){
        System.out.println("时间："+System.currentTimeMillis());
    }

    /**
     * 定时任务
     * 每天凌晨1点整执行一次
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void testTask1(){
        System.out.println("时间："+System.currentTimeMillis());
    }


    /**
     * 异步执行
     *
     * @throws Exception
     */
    @Async
    public void asyncDo() throws Exception{
        Thread.sleep(3000);
        System.out.println("异步执行中======"+System.currentTimeMillis());
    }

}

