package com.dev.kafka.SampleOne.kafka;

import com.dev.kafka.SampleOne.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.dev.kafka.SampleOne.constant.Constants.TEST_JSON_TOPIC_NAME;

@Slf4j
@Service
public class MyJsonKafkaConsumer {

    @KafkaListener(topics = TEST_JSON_TOPIC_NAME, groupId="springboot-consume-json-test")
    public void consumeJsonMessage(User userData){

        log.info("Json Message Received -> {}",userData.toString());
    }
}
