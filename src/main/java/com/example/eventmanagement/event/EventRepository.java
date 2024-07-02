package com.example.eventmanagement.event;

import java.util.HashMap;
import java.util.Map;

public class EventRepository {
    private final Map<Long, Event> events = new HashMap<>();

    public Event save(Event event) {
        events.put(event.getId(), event);
        return event;
    }

    public Event findById(Long eventId) {
        return events.get(eventId);
    }

    public void deleteById(Long eventId) {
        events.remove(eventId);
    }

    public List<Event> findAll() {
        return new ArrayList<>(events.values());
    }
}
