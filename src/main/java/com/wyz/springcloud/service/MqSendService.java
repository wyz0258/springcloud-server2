package com.wyz.springcloud.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/27
 */
@Component
public class MqSendService {


    @Autowired
    RabbitTemplate rabbitTemplate;

    public void  send(String msg){
        rabbitTemplate.convertAndSend("hello",msg);
    }

    public void sendByFanout(String msg){
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE","",msg);
    }

}
