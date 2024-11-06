package com.ecommerce.payment.service.impl;

import com.ecommerce.payment.dao.PaymentDao;
import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;
import com.ecommerce.payment.security.JwtUtil;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    //setup payment method
    @Override
    public PaymentDto createPayment(PaymentDto paymentDto, Long userId){
        Payment payment = mapToEntity(paymentDto);
        payment.setUserId(userId);
        payment.setCreateDateTime();
        Payment savedPayment = paymentDao.save(payment);
        return mapToDto(savedPayment);
    }

    // Verify client input
    @Override
    public boolean verifyPayment(PaymentDto paymentDto, Long userId) {
        Optional<Payment> payment = paymentDao.findById(userId);
        if (payment.isPresent()) {
            PaymentDto existedPaymentDto = mapToDto(payment.get());
            return CompareTwoPaymentDto(paymentDto, existedPaymentDto);
        }
        return false;
    }

    @Override
    public MakePaymentResponse makePayment(PaymentDto paymentDto, Long userId) {
        MakePaymentResponse response = new MakePaymentResponse();
        if (verifyPayment(paymentDto, userId)) {
            response.setUserId(userId);
            response.setOrderId(paymentDto.getOrderId());
            response.setPaymentStatus("PAID");
        }
        else {
            throw new NullPointerException("Payment is unverified!");
        }
        return response;
    }

    private boolean CompareTwoPaymentDto (PaymentDto paymentDto1, PaymentDto paymentDto2) {
        if (paymentDto1 == null || paymentDto2 == null) return false;
        if (!paymentDto1.getPaymentCard().equals(paymentDto2.getPaymentCard())) return false;
        if (!paymentDto1.getCardExpiration().equals(paymentDto2.getCardExpiration())) return false;
        if (paymentDto1.getCvv() != paymentDto2.getCvv()) return false;
        if (!paymentDto1.getBillingAddress().equalsIgnoreCase(paymentDto2.getBillingAddress())) return false;
        if (paymentDto1.getZIP() != paymentDto2.getZIP()) return false;
        return true;
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
