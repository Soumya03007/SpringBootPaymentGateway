package com.springbootpaymentgatewayrazorpay.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.springbootpaymentgatewayrazorpay.dto.CreateOrderRequest;
import com.springbootpaymentgatewayrazorpay.dto.CreateOrderResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    private final RazorpayClient razorpayClient;

    public RazorpayService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }


    public CreateOrderResponse createOrder(CreateOrderRequest request) throws RazorpayException {
        try {

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", request.getAmount());
            orderRequest.put("currency", request.getCurrency());
            orderRequest.put("receipt", "receipt#1");



            Order order = razorpayClient.orders.create(orderRequest);


            CreateOrderResponse response = new CreateOrderResponse();


            response.setId((String) order.get("id"));
            response.setEntity((String) order.get("entity"));
            response.setAmount(order.get("amount"));
            response.setAmountPaid(order.get("amount_paid"));
            response.setAmountDue(order.get("amount_due"));
            response.setCurrency((String) order.get("currency"));
            response.setStatus((String) order.get("status"));
            response.setAttempts(order.get("attempts"));


            return response; // Return the DTO

        } catch (RazorpayException e) {

            System.err.println("RazorpayException during order creation: " + e.getMessage());

            throw e;
        } catch (JSONException e) {

            System.err.println("JSONException during Razorpay response parsing: " + e.getMessage());
            throw new RazorpayException("Error parsing Razorpay response: " + e.getMessage());
        }
    }
}
