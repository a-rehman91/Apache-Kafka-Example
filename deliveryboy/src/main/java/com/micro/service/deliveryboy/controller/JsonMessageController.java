package com.micro.service.deliveryboy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.micro.service.deliveryboy.payload.User;
import com.micro.service.deliveryboy.service.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) throws JsonProcessingException {

        System.out.println("testestest------------");
        jsonKafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to kafka topic");
    }
}
