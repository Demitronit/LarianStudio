package com.example.LarianStudio.Events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventLogger {

    private static final Logger logger = LoggerFactory.getLogger(EventLogger.class);

    public void logEvent(String event) {
        logger.info(event);
    }
}