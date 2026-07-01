package ru.ivanov.igor.kafkaone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.ivanov.igor.kafkaone.dto.PostedMessageResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class MessageResponseToKafka {
    private final KafkaTemplate<String, PostedMessageResponse> kafkaTemplate;

    public MessageResponseToKafka(KafkaTemplate<String, PostedMessageResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg_id) throws Exception {
        PostedMessageResponse messageResponse = new PostedMessageResponse(
                msg_id,
                System.currentTimeMillis(),
                "POST",
                "/post-message"
        );

        kafkaTemplate
                .send("postedmessages", messageResponse)
                .get();
    }
}
