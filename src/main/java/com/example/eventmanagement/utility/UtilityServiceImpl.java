package com.example.eventmanagement.utility;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Override
    public List<String> getUtilities() {
        List<String> utilities = new ArrayList<>();
        utilities.add("Catering");
        utilities.add("Decoration");
        utilities.add("Audio/Visual");
        return utilities;
    }
}
