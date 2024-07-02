package com.example.eventmanagement.event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event);
    void deleteEvent(Long eventId);
    Event getEventDetails(Long eventId);
}
