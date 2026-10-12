package com.dev.kafka.SampleOne.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.dev.kafka.SampleOne.constant.Constants.TEST_TOPIC_NAME;

@Slf4j
@Service
public class MyKafkaProducer {

    private KafkaTemplate<String,String> kafkaTemplate ;


    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        kafkaTemplate.send(TEST_TOPIC_NAME,message);
        log.info(String.format("Message Send {%s}",message));
    }
}
