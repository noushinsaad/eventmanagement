package com.example.eventmanagement.payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    private final Map<Long, Payment> payments = new HashMap<>();

    public Payment save(Payment payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }

    public Payment findById(Long paymentId) {
        return payments.get(paymentId);
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments.values());
    }
}
