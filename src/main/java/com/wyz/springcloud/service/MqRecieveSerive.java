package com.wyz.springcloud.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/27
 */
@Component
//@RabbitListener(queues = "hello")
public class MqRecieveSerive {

    @RabbitHandler
    @RabbitListener(queues = "FANOUT_QUEUE")
    public void process(String msg){
        System.out.println("接收1"+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "FANOUT_QUEUE2")
    public void process2(String msg){
        System.out.println("接收2"+msg);
    }


}
