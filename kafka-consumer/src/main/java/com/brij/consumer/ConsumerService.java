package com.brij.consumer;

import com.brij.Message;
import com.brij.dtos.AnotherMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@KafkaListener(topics = "${topic_name}")
public class ConsumerService {

    @KafkaHandler()
    public void consumeMessage(Message message, Acknowledgment acknowledgment) {
        log.info("Message received {}", message);
        acknowledgment.acknowledge();

    }

    @KafkaHandler()
    public void consumeAnotherMessage(AnotherMessage message, Acknowledgment acknowledgment) {
        log.info("Message received {}", message);
        acknowledgment.acknowledge();

    }

}
