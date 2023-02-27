package com.daneking.springboot.event;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PublisherTest {
    @Autowired
    private Publisher publisher;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @SpyBean
    private Listener listener;

    @Test
    void shouldPublishEvent() {
        publisher.fireEvent("name");
        //capture to verify contents
        verify(listener).onEventFired(isA(EventFired.class));

    }

}