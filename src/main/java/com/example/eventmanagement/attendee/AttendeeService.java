package com.example.eventmanagement.attendee;

import java.util.List;

public interface AttendeeService {
    Attendee registerAttendee(Attendee attendee);
    Attendee getAttendeeDetails(Long attendeeId);
}
