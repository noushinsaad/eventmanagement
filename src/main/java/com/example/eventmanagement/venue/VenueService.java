package com.example.eventmanagement.venue;

import java.util.List;

public interface VenueService {
    Venue checkAvailableVenues();
    Venue bookVenue(Venue venue);
}
