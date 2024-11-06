package com.ecommerce.payment.controller;

import com.ecommerce.payment.payload.CreatePaymentMethodResponse;
import com.ecommerce.payment.payload.MakePaymentResponse;
import com.ecommerce.payment.payload.PaymentDto;
import com.ecommerce.payment.security.JwtUtil;
import com.ecommerce.payment.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;
    private HttpServletRequest request;
    private JwtUtil jwtUtil;

    @Autowired
    public PaymentController(PaymentService paymentService, HttpServletRequest request, JwtUtil jwtUtil) {
        this.paymentService = paymentService;
        this.request = request;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/createPaymentMethod")
    public ResponseEntity<CreatePaymentMethodResponse> createPaymentMethod(@RequestBody PaymentDto paymentDto) {
        String token = jwtUtil.getJwtToken(request);
        Long orderId = paymentDto.getOrderId();
        if (token == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Long userId = jwtUtil.extractUserId(token);
        PaymentDto dto = paymentService.createPayment(paymentDto, userId);
        CreatePaymentMethodResponse response = mapToResponse(dto);
        response.setOrderId(orderId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/makePayment")
    public ResponseEntity<MakePaymentResponse> makePayment(@RequestBody PaymentDto paymentDto) {
        String token = jwtUtil.getJwtToken(request);
        if (token == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Long userId = jwtUtil.extractUserId(token);
        MakePaymentResponse response = paymentService.makePayment(paymentDto, userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private CreatePaymentMethodResponse mapToResponse(PaymentDto paymentDto) {
        CreatePaymentMethodResponse response = new CreatePaymentMethodResponse();
        response.setPaymentStatus("UNPAID");
        response.setPaymentCard(paymentDto.getPaymentCard());
        response.setBillingAddress(paymentDto.getBillingAddress());
        response.setZIP(paymentDto.getZIP());
        return response;
    }
}
