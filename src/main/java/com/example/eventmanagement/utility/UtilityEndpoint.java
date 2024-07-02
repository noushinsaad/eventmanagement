package com.example.eventmanagement.utility;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UtilityEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/utilities";

    private final UtilityService utilityService;

    public UtilityEndpoint(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUtilitiesRequest")
    @ResponsePayload
    public GetUtilitiesResponse getUtilities(@RequestPayload GetUtilitiesRequest request) {
        GetUtilitiesResponse response = new GetUtilitiesResponse();
        response.getUtilities().addAll(utilityService.getUtilities());
        return response;
    }
}
