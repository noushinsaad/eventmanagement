package com.example.eventmanagement.event;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {
    private final Map<Long, Event> events = new HashMap<>();

    @Override
    public Event createEvent(Event event) {
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        events.put(event.getId(), event);
        return event;
    }

    @Override
    public void deleteEvent(Long eventId) {
        events.remove(eventId);
    }

    @Override
    public Event getEventDetails(Long eventId) {
        return events.get(eventId);
    }
}
