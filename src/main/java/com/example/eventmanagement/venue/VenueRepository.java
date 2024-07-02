package com.example.eventmanagement.venue;

import java.util.HashMap;
import java.util.Map;

public class VenueRepository {
    private final Map<Long, Venue> venues = new HashMap<>();

    public Venue save(Venue venue) {
        venues.put(venue.getId(), venue);
        return venue;
    }

    public Venue findById(Long venueId) {
        return venues.get(venueId);
    }

    public List<Venue> findAll() {
        return new ArrayList<>(venues.values());
    }
}
