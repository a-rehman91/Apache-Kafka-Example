package com.micro.service.enduser.enduser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_NAME, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value){

        this.logger.info("Updated Location is : " + value);
    }
}
