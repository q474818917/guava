package com.google.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusSample {

    private final static String EVENT_BUS_IDENTIFY = "snoopy";
    private EventBus eventBus;

    private EventBusSample() {
        eventBus = new EventBus(EVENT_BUS_IDENTIFY);
    }

    public void produce(Object event) {
        this.eventBus.post(event);
    }

    public void register(Object object) {
        this.eventBus.register(object);
    }

    public static void main(String args[]) {
        NotifyEvent notifyEvent = new NotifyEvent();
        notifyEvent.setId("001");
        notifyEvent.setMsg("deliver message 01");
        EventBusSample eventBusSample = new EventBusSample();
        eventBusSample.register(new EventListener());
        eventBusSample.produce(notifyEvent);
    }
}
