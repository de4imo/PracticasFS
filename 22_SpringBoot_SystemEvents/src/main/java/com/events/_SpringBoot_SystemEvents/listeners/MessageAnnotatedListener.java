package com.events._SpringBoot_SystemEvents.listeners;

import com.events._SpringBoot_SystemEvents.model.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageAnnotatedListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageAnnotatedListener.class);

    @EventListener
    public void processMessageEvent(MessageEvent event) {
        logger.info("Event received, content = " + event.getMessage() + ", timestamp " + event.getTimestamp());
    }
}