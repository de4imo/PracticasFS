package com.events._SpringBoot_SystemEvents.listeners;

import com.events._SpringBoot_SystemEvents.model.MessageEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessageAsyncListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageAsyncListener.class);

    @EventListener
    @Async
    public void processMessageEvent(MessageEvent event) {
        logger.info("Procesing event asynchronous, content = " + event.getMessage() + ", timestamp "
                + event.getTimestamp());
    }
}