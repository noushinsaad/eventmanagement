package com.example.eventmanagement.attendee;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final Map<Long, Attendee> attendees = new HashMap<>();

    @Override
    public Attendee registerAttendee(Attendee attendee) {
        attendees.put(attendee.getId(), attendee);
        return attendee;
    }

    @Override
    public Attendee getAttendeeDetails(Long attendeeId) {
        return attendees.get(attendeeId);
    }
}
