package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author : wangyz
 * @Description :
 * @Date :  2017/7/13
 */

@SpringBootApplication(scanBasePackages="com.wyz.springcloud")
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@EnableAsync
public class ServerApplication {


    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
    @Bean
    public Queue fanoutQueue(){
        return new Queue("FANOUT_QUEUE");
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("FANOUT_QUEUE2");
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
