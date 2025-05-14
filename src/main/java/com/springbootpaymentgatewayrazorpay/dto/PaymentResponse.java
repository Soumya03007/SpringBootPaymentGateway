package com.springbootpaymentgatewayrazorpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private String orderId;
    private int amount;
    private String currency;
    private String message; // Add message field for error details

    public PaymentResponse(String message, int amount, String currency) {
        this.message = message;
        this.amount = amount;
        this.currency = currency;
    }
}
