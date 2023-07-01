import com.brij.Message;
import com.brij.consumer.ConsumerApplication;
import com.brij.consumer.ConsumerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;


@SpringBootTest(classes = ConsumerApplication.class)
@EmbeddedKafka(brokerProperties = {"listeners=PLAINTEXT://localhost:9094"}, partitions = 1)
public class ConsumerServiceTest {

    @Autowired
    ConsumerRepo repo;

    @Autowired
    KafkaTemplate template;
    @Test
    void shouldAddNewMessage() throws InterruptedException {
        // new message to published
        // repo should return the message
        Message message = new Message();
        message.setId(1L);
        message.setMessage("test message");
        template.send("message-topic", message);
//        Thread.sleep(500);
        await().atMost(Duration.ofMillis(1000)).untilAsserted(()->{
            Message message1 = repo.getMessage(1L);
            assertThat(message1).isNotNull();
            assertThat(message1.getMessage()).isEqualTo("test message");
            assertThat(message1.getId()).isEqualTo(1L);
        });


    }


}
