package com.brij;

import com.brij.dtos.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
public class ProducerService {
    @Value("${topic_name}")
    public String topicName;

    @Autowired
    KafkaTemplate<String, Message> template;

    public String sendMessage(String key, Message message) {
        CompletableFuture<SendResult<String, Message>> completable = template.send(topicName, key, message).completable();
        completable.whenComplete(((result, error) -> {
            if (Objects.nonNull(error)) {
                log.error("Failed  to send message ", error);
                throw new RuntimeException("Failed to send message");
            } else {
                log.info("Successfully sent message {}", result);
            }
        }));
        return "Successfully sent message";

    }


}
