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


@Service
@Slf4j
public class ProducerService {
    @Value("${topic_name}")
    public String topicName;

    @Autowired
    KafkaTemplate<String, Message> template;

    public void sendMessage(String key, Message message) {
        ListenableFuture<SendResult<String, Message>> resultListenableFuture = template.send(topicName, key, message);
        resultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Failed  to send message", ex);

            }

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                log.info("Successfully send message {}", result);
            }
        });
    }


}
