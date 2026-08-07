package com.ecommerce.payment.service;

import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;

import java.util.Map;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto, Long userId);
    boolean verifyPayment(PaymentDto paymentDto, Long userId);
    MakePaymentResponse makePayment(PaymentDto paymentDto, Long userId);
}
