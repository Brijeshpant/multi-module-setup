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
public class ConsumerService {
    private final ConsumerRepo consumerRepo;

    public ConsumerService(ConsumerRepo repo) {
        this.consumerRepo = repo;
    }

    @KafkaListener(topics = "${topic_name}", groupId = "${group_id}")
    public void consumeMessage(Message message, Acknowledgment acknowledgment) {
        log.info("Message received {}", message);
        consumerRepo.addUpdateMessages(message);
        acknowledgment.acknowledge();

    }

}
