package com.receiver.receiverApp.config;


import com.receiver.receiverApp.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConfig.class);
    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME,groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value)
    {
            logger.info("Inside Receiver ");
            logger.info("Getting value :: "+value);

    }
}
