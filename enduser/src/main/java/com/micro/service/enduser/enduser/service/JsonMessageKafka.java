package com.micro.service.enduser.enduser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.service.enduser.enduser.config.AppConstants;
import com.micro.service.enduser.enduser.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonMessageKafka {

    private static final Logger logger = LoggerFactory.getLogger(JsonMessageKafka.class);

    @KafkaListener(topics = AppConstants.JSON_MSG_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String jsonUser) throws JsonProcessingException {

        logger.info("Json received -> " + jsonUser);
    }
}
