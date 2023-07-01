package com.brij.consumer;

import com.brij.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumerRepo {
    Map<Long, Message> messages = new HashMap<>();

    public void addUpdateMessages(Message message) {
        messages.put(message.getId(), message);
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }
}
