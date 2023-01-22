package com.example.rabbitservice.api;

import com.example.rabbitservice.domain.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public void postMessage(@RequestBody Message message) {
        log.info("Received http message, {}", message.body());
        rabbitTemplate.convertAndSend("message-fanout", "", message.body());
    }
}
