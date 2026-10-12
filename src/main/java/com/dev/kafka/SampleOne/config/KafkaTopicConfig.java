
package com.dev.kafka.SampleOne.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.dev.kafka.SampleOne.constant.Constants.TEST_JSON_TOPIC_NAME;
import static com.dev.kafka.SampleOne.constant.Constants.TEST_TOPIC_NAME;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(TEST_TOPIC_NAME).build();
    }

    @Bean
    public NewTopic createJsonTopic() {
        return TopicBuilder.name(TEST_JSON_TOPIC_NAME).build();
    }
}
