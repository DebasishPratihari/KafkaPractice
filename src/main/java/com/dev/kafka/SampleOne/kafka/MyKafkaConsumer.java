package com.dev.kafka.SampleOne.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.dev.kafka.SampleOne.constant.Constants.TEST_TOPIC_NAME;

@Slf4j
@Service
public class MyKafkaConsumer {

    @KafkaListener(topics=TEST_TOPIC_NAME,groupId ="springboot-consume-test" )
    public void consume(String message){

        log.info(String.format("Message Received -> %s",message));

    }
}
