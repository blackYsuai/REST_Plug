package ru.ivanov.igor.kafkaone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.igor.kafkaone.dto.MessageRequest;
import ru.ivanov.igor.kafkaone.service.MessageResponseToKafka;

@RestController
@RequestMapping("/post-message")
public class
KafkaMessageController {

    private final MessageResponseToKafka messageResponseToKafka;

    @Autowired
    public KafkaMessageController(MessageResponseToKafka messageResponseToKafka) {
        this.messageResponseToKafka = messageResponseToKafka;
    }


    @PostMapping()
    public ResponseEntity<?> postMessage(@RequestBody MessageRequest messageRequest){
        try{
            messageResponseToKafka.sendMessage(messageRequest.msg_id());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
