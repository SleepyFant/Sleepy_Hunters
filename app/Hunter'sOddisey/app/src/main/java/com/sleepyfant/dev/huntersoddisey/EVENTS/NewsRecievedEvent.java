package com.sleepyfant.dev.huntersoddisey.EVENTS;

import java.util.List;

/**
 * Created by usuari on 10/10/2015.
 */
public class NewsRecievedEvent {
    List<String> items;

    public NewsRecievedEvent(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return this.items;
    }
}
