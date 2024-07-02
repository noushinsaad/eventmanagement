package com.example.eventmanagement.attendee;

import java.util.HashMap;
import java.util.Map;

public class AttendeeRepository {
    private final Map<Long, Attendee> attendees = new HashMap<>();

    public Attendee save(Attendee attendee) {
        attendees.put(attendee.getId(), attendee);
        return attendee;
    }

    public Attendee findById(Long attendeeId) {
        return attendees.get(attendeeId);
    }

    public List<Attendee> findAll() {
        return new ArrayList<>(attendees.values());
    }
}
