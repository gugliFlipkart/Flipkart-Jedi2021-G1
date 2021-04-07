package com.flipkart.handler;

import com.flipkart.service.PaymentInterface;
import com.flipkart.service.PaymentService;

public class PaymentHandler {
    PaymentInterface paymentService = new PaymentService();

    public void make_payment(String studentId) {
        paymentService.make_payment(studentId);
    }

}
