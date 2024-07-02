package com.example.eventmanagement.venue;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class VenueEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/venues";

    private final VenueService venueService;

    public VenueEndpoint(VenueService venueService) {
        this.venueService = venueService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkAvailableVenuesRequest")
    @ResponsePayload
    public CheckAvailableVenuesResponse checkAvailableVenues(@RequestPayload CheckAvailableVenuesRequest request) {
        CheckAvailableVenuesResponse response = new CheckAvailableVenuesResponse();
        response.setVenues(venueService.checkAvailableVenues());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "bookVenueRequest")
    @ResponsePayload
    public BookVenueResponse bookVenue(@RequestPayload BookVenueRequest request) {
        BookVenueResponse response = new BookVenueResponse();
        response.setVenue(venueService.bookVenue(request.getVenue()));
        return response;
    }

}
