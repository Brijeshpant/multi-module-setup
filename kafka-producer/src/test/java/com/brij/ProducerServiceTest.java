package com.brij;

import com.brij.dtos.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ProducerApplication.class)
@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9094"}, partitions = 1)
public class ProducerServiceTest {
    @Autowired
    ProducerService producerService;

    @Test
    void shouldPublishMessage() throws InterruptedException {
        Message message = new Message();
        message.setId(1L);
        message.setMessage("test message");
        String response = producerService.sendMessage("test", message);
        assertThat(response).contains("Successfully sent");
    }


}
