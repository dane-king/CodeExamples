package com.daneking.springboot.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @EventListener
    public void onEventFired(EventFired eventFired){
        System.out.println("Event fired :" + eventFired);
    }
}
