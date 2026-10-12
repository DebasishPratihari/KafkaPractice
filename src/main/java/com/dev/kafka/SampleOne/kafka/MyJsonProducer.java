package com.dev.kafka.SampleOne.kafka;

import com.dev.kafka.SampleOne.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static com.dev.kafka.SampleOne.constant.Constants.TEST_JSON_TOPIC_NAME;

@Service
@Slf4j
public class MyJsonProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public MyJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJsonMessage(User userData){
        log.info("Message send to Kafka : {}", userData.toString());

      Message<User> message= MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC,TEST_JSON_TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
        log.info("Message send to Kafka : {}", userData.toString());
    }
}
