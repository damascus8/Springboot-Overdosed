package com.sender.senderApp.service;


import com.sender.senderApp.constants.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {


    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public boolean updateLocation(String location)
    {
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        logger.info("in service");
        logger.info("location produced");
        return true;
    }

}


