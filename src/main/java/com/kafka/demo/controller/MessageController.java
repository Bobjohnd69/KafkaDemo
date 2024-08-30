package com.kafka.demo.controller;

import com.kafka.demo.consumer.KafkaConsumer;
import com.kafka.demo.payload.Student;
import com.kafka.demo.producer.KafkaJsonProducer;
import com.kafka.demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage("Seg", message);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage("Seg", student);
        return ResponseEntity.ok("Message sent as JSON");
    }
}
