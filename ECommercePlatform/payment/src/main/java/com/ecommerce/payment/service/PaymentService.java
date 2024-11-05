package com.ecommerce.payment.service;

import com.ecommerce.payment.payload.PaymentDto;

public interface PaymentService {
    PaymentDto createPayment(PaymentDto paymentDto);
    PaymentDto comparePayment(PaymentDto paymentDto);
}
