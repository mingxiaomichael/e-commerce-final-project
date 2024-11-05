package com.ecommerce.payment.service.impl;

import com.ecommerce.payment.dao.PaymentDao;
import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.payload.PaymentDto;
import com.ecommerce.payment.security.JwtUtil;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private JwtUtil jwtUtil;

    //setup payment method
    public PaymentDto createPayment(PaymentDto paymentDto){
        Payment payment = mapToEntity(paymentDto);
        //userId retrived by token extraction
        String token = jwtUtil.getToken();
        Long userId = jwtUtil.extractUserId(token);
        payment.setUserId(userId);
        payment.setPaymentStatus("UNPAID");
        Payment savedPayment = paymentDao.save(payment);

        return mapToDto(savedPayment);
    }

    public PaymentDto comparePayment(PaymentDto paymentDto){
        return null;
    }


    private PaymentDto mapToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentCard(payment.getPaymentCard());
        paymentDto.setCardExpiration(payment.getCardExpiration());
        paymentDto.setCvv(payment.getCvv());
        paymentDto.setBillingAddress(payment.getBillingAddress());
        paymentDto.setZIP(payment.getZIP());
        return paymentDto;
    }

    private Payment mapToEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setPaymentCard(paymentDto.getPaymentCard());
        payment.setCardExpiration(paymentDto.getCardExpiration());
        payment.setCvv(paymentDto.getCvv());
        payment.setBillingAddress(paymentDto.getBillingAddress());
        payment.setZIP(paymentDto.getZIP());
        return payment;
    }

}
