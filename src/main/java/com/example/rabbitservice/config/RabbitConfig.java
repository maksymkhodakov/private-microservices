package com.example.rabbitservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {

    @Bean
    public Queue localSpringQueue() {
        return new Queue("spring-fanout");
    }

    @Bean
    public Exchange messageExchangeFanout() {
        return new FanoutExchange("message-fanout");
    }

    @Bean
    public Binding springQueueBinding() {
        return BindingBuilder
                .bind(localSpringQueue())
                .to(messageExchangeFanout())
                .with("").noargs();
    }
}
