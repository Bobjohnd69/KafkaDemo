package com.kafka.demo.consumer;

import com.kafka.demo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "Seg", groupId = "consumer-group-1")
//    public void consume(String message) {
//        log.info("Messages has been consumed: " + message);
//    }

    @KafkaListener(topics = "Seg", groupId = "consumer-group-1")
    public void consumeJsonMsq(Student student) {
        log.info("Messages has been consumed");
    }
}
