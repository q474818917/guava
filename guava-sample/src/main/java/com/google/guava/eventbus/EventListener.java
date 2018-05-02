package com.google.guava.eventbus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener {

    private static Logger logger = LoggerFactory.getLogger(EventListener.class);

    @Subscribe
    public void subscribe(NotifyEvent notifyEvent) {
        logger.info("eventListener notifyEvent is {}", notifyEvent.toString());
    }
}
