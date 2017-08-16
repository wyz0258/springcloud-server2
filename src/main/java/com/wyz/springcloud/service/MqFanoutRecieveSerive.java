package com.wyz.springcloud.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/27
 */
//@Component
//@RabbitListener(queues = "FANOUT_QUEUE2" )
public class MqFanoutRecieveSerive {

//    @RabbitHandler
//    @RabbitListener(queues = "FANOUT_QUEUE2")
//    public void process(String msg){
//        System.out.println("接收"+msg);
//    }


}
