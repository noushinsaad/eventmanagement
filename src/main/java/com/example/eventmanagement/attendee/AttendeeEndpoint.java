package com.example.eventmanagement.attendee;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AttendeeEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/attendees";

    private final AttendeeService attendeeService;

    public AttendeeEndpoint(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "registerAttendeeRequest")
    @ResponsePayload
    public RegisterAttendeeResponse registerAttendee(@RequestPayload RegisterAttendeeRequest request) {
        RegisterAttendeeResponse response = new RegisterAttendeeResponse();
        response.setAttendee(attendeeService.registerAttendee(request.getAttendee()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAttendeeDetailsRequest")
    @ResponsePayload
    public GetAttendeeDetailsResponse getAttendeeDetails(@RequestPayload GetAttendeeDetailsRequest request) {
        GetAttendeeDetailsResponse response = new GetAttendeeDetailsResponse();
        response.setAttendee(attendeeService.getAttendeeDetails(request.getAttendeeId()));
        return response;
    }

}
