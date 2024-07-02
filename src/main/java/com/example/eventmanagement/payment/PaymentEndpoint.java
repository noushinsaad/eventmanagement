package com.example.eventmanagement.payment;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/payments";

    private final PaymentService paymentService;

    public PaymentEndpoint(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processPaymentRequest")
    @ResponsePayload
    public ProcessPaymentResponse processPayment(@RequestPayload ProcessPaymentRequest request) {
        ProcessPaymentResponse response = new ProcessPaymentResponse();
        response.setPayment(paymentService.processPayment(request.getPayment()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaymentDetailsRequest")
    @ResponsePayload
    public GetPaymentDetailsResponse getPaymentDetails(@RequestPayload GetPaymentDetailsRequest request) {
        GetPaymentDetailsResponse response = new GetPaymentDetailsResponse();
        response.setPayment(paymentService.getPaymentDetails(request.getPaymentId()));
        return response;
    }
}
