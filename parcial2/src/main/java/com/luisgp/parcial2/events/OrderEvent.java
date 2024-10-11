package com.luisgp.parcial2.events;

import lombok.Data;
import java.util.Date;

@Data
public class OrderEvent extends Event<OrderEventData> {
    
    public OrderEvent(Date date, EventType type, OrderEventData data) {
        super(date, type, data);
    }
}