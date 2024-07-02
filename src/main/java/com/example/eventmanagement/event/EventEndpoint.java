package com.example.eventmanagement.event;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/events";

    private final EventService eventService;

    public EventEndpoint(EventService eventService) {
        this.eventService = eventService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEventRequest")
    @ResponsePayload
    public CreateEventResponse createEvent(@RequestPayload CreateEventRequest request) {
        CreateEventResponse response = new CreateEventResponse();
        response.setEvent(eventService.createEvent(request.getEvent()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEventRequest")
    @ResponsePayload
    public UpdateEventResponse updateEvent(@RequestPayload UpdateEventRequest request) {
        UpdateEventResponse response = new UpdateEventResponse();
        response.setEvent(eventService.updateEvent(request.getEvent()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEventRequest")
    @ResponsePayload
    public DeleteEventResponse deleteEvent(@RequestPayload DeleteEventRequest request) {
        DeleteEventResponse response = new DeleteEventResponse();
        response.setSuccess(eventService.deleteEvent(request.getEventId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventDetailsRequest")
    @ResponsePayload
    public GetEventDetailsResponse getEventDetails(@RequestPayload GetEventDetailsRequest request) {
        GetEventDetailsResponse response = new GetEventDetailsResponse();
        response.setEvent(eventService.getEventDetails(request.getEventId()));
        return response;
    }

}
