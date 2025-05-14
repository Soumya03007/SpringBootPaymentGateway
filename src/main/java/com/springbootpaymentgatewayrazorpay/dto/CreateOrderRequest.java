package com.springbootpaymentgatewayrazorpay.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private int amount;
    private String currency;

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
