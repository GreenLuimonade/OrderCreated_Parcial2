package com.luisgp.parcial2.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Kafka {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public Kafka(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderEvent orderEvent) {
        kafkaTemplate.send("OrderCreated", orderEvent);
    }
}
