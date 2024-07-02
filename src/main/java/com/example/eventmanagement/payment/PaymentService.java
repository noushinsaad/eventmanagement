package com.example.eventmanagement.payment;

import java.util.List;

public interface PaymentService {
    Payment processPayment(Payment payment);
    Payment getPaymentDetails(Long paymentId);
}
