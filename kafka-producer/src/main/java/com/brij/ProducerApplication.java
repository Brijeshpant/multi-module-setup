package com.brij;

import com.brij.dtos.AnotherMessage;
import com.brij.dtos.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProducerService producer) {
        return args -> {
            Message message = new Message();
            message.setId(1L);
            message.setMessage("Hello1");
            producer.sendMessage("key2", message);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner1(AnotherProducerService producer) {
        return args -> {
            AnotherMessage message = new AnotherMessage();
            message.setId(2L);
            message.setAnotherMessage("Hi all");
            producer.sendMessage("key3", message);
        };
    }
}
