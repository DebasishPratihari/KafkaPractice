package com.dev.kafka.SampleOne.controller;

import com.dev.kafka.SampleOne.kafka.MyJsonProducer;
import com.dev.kafka.SampleOne.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final MyJsonProducer jsonProducer;

    public JsonMessageController(MyJsonProducer jsonProducer) {
       this. jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish (@RequestBody User userData){

        jsonProducer.sendJsonMessage(userData);

        return ResponseEntity.ok(
                String.format("Json Message Sent -> %s",userData.toString())
        );
    }
}
