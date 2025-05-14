package com.springbootpaymentgatewayrazorpay.controller;

import com.razorpay.RazorpayException;
import com.springbootpaymentgatewayrazorpay.dto.CreateOrderRequest;
import com.springbootpaymentgatewayrazorpay.dto.CreateOrderResponse; // Import the new success DTO
import com.springbootpaymentgatewayrazorpay.dto.PaymentResponse;
import com.springbootpaymentgatewayrazorpay.service.RazorpayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final RazorpayService razorpayService;

    public PaymentController(RazorpayService razorpayService) {
        this.razorpayService = razorpayService;
    }

    @PostMapping("/create-order")
    // Return type can remain ResponseEntity<Object> or change to ResponseEntity<CreateOrderResponse>
    // if you prefer, but ResponseEntity<Object> allows returning both success and error DTOs.
    public ResponseEntity<Object> createOrder(@RequestBody CreateOrderRequest request) {
        try {
            // Receive the CreateOrderResponse object from the service
            CreateOrderResponse successResponse = razorpayService.createOrder(request);

            // Return the DTO in the ResponseEntity. Spring will serialize it to JSON.
            return ResponseEntity.ok(successResponse);

        } catch (RazorpayException e) {
            // This block handles errors and already returns a DTO, which works.
            PaymentResponse errorResponse = new PaymentResponse("Error", 0, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}