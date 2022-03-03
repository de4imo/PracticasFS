package com.events._SpringBoot_SystemEvents.listeners;

import com.events._SpringBoot_SystemEvents.model.MessageEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    public void onApplicationEvent(MessageEvent event) {
        logger.info("Event received, content = " + event.getMessage() + ", timestamp " + event.getTimestamp());
    }

}
