package com.example.eventmanagement.venue;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VenueServiceImpl implements VenueService {
    private final Map<Long, Venue> venues = new HashMap<>();

    @Override
    public Venue checkAvailableVenues() {
        for (Venue venue : venues.values()) {
            if (!venue.isBooked()) {
                return venue; // Return the first available venue found
            }
        }
        return null; // Return null if no available venue is found
    }

    @Override
    public Venue bookVenue(Venue venue) {
        venues.put(venue.getId(), venue);
        return venue;
    }
}
