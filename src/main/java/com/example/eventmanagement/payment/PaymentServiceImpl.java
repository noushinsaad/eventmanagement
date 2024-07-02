package com.example.eventmanagement.payment;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final Map<Long, Payment> payments = new HashMap<>();

    @Override
    public Payment processPayment(Payment payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Payment getPaymentDetails(Long paymentId) {
        return payments.get(paymentId);
    }
}
