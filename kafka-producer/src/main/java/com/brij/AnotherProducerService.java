package com.brij;

import com.brij.dtos.AnotherMessage;
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
public class AnotherProducerService {
    @Value("${topic_name}")
    public String topicName;

    @Autowired
    KafkaTemplate<String, AnotherMessage> template;

    public void sendMessage(String key, AnotherMessage message) {

        CompletableFuture<SendResult<String, AnotherMessage>> completable = template.send(topicName, key, message).completable();
        completable.whenComplete((success, ex) -> {
            if (Objects.isNull(ex)) {
                log.info("Successfully send message {}", success);

            } else {
                log.error("Failed  to send message", ex);

            }
        });

    }


}
