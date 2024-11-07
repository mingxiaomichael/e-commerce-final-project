package com.ecommerce.order.client;

import com.ecommerce.payment.payload.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ecommerce.payment.payload.MakePaymentResponse;
@FeignClient(name = "payment", url = "http://localhost:8082/payment",configuration = FeignClientConfig.class)
public interface PaymentClient {
    @RequestMapping("/makePayment")
    ResponseEntity<MakePaymentResponse> makePayment(@RequestBody PaymentDto paymentDto);


}
