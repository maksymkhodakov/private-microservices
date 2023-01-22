package com.example.rabbitservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = "spring-queue")
    public void printMessage(String message) {
        log.info("Read message: {}", message);
    }
}
