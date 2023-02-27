package com.daneking.springboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void fireEvent(String name){
        publisher.publishEvent(new EventFired(name, "success"));
    }
}
