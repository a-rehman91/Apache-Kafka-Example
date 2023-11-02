package com.micro.service.deliveryboy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.service.deliveryboy.config.AppConstants;
import com.micro.service.deliveryboy.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendJsonMessage(User user) throws JsonProcessingException {

        logger.info("Message sent -> %s" , user.toString());

        String jsonUser = new ObjectMapper().writeValueAsString(user);
        Message<String> message = MessageBuilder
                .withPayload(jsonUser)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.JSON_MSG_TOPIC_NAME)
                .build();

        this.kafkaTemplate.send(message);
    }
}
