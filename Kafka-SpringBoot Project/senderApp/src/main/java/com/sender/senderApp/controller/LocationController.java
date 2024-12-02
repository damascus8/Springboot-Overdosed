package com.sender.senderApp.controller;


import com.sender.senderApp.service.KafkaService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    private Logger logger = LoggerFactory.getLogger(LocationController.class);
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation()
    {
        logger.info("In controller begins::");

        // Generate random latitude (-90 to 90)

        for(int i =1;i<=20000;i++){
            double latitude = ThreadLocalRandom.current().nextDouble(-90, 90);

            // Generate random longitude (-180 to 180)
            double longitude = ThreadLocalRandom.current().nextDouble(-180, 180);

            // Format to 2 decimal places for readability
        System.out.printf("Random Coordinates: %.2f, %.2f%n", latitude, longitude);
        String location = String.format("%.2f, %.2f", latitude, longitude);

        logger.info("value of location ::" + location);
        logger.info("val of i "+i);
        kafkaService.updateLocation(location);

    }


        return new ResponseEntity<>(Map.of("message","Location Updated !"), HttpStatus.OK) ;

    }
}
