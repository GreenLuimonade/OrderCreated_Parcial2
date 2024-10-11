package com.luisgp.parcial2.events;

import lombok.Data;
import java.util.Date;

@Data
public abstract class Event <T> {
    private Date date;
    private EventType type;
    private T data;

    public Event(Date date, EventType type, T data) {
        this.date = date;
        this.type = type;
        this.data = data;
    }
}
