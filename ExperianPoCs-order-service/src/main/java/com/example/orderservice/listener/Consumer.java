package com.example.orderservice.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "test.queue")
    public void consume(String message) {
        System.out.println(" Unsuccessful order, order Id: " + message);
    }
}
