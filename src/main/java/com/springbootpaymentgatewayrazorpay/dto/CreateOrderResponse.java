package com.springbootpaymentgatewayrazorpay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// We are manually adding getters and setters for all fields because Lombok is not working.
// If Lombok were working, none of these manual methods would be necessary,
// and you could potentially remove the @Data annotation if you only needed getters/setters.
@Data // Keeping @Data here, but it's not effectively generating methods in your environment.
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
    private String id;          // The field
    private String entity;      // The field
    private int amount;         // The field
    private int amountPaid;     // The field
    private int amountDue;      // The field
    private String currency;    // The field
    private String status;      // The field
    private int attempts;       // The field

    // Manually added getter for 'id'
    public String getId() {
        return id;
    }

    // Manually added setter for 'id'
    public void setId(String id) {
        this.id = id;
    }

    // Manually added getter for 'entity'
    public String getEntity() {
        return entity;
    }

    // Manually added setter for 'entity'
    public void setEntity(String entity) {
        this.entity = entity;
    }

    // Manually added getter for 'amount'
    public int getAmount() {
        return amount;
    }

    // Manually added setter for 'amount'
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Manually added getter for 'amountPaid'
    public int getAmountPaid() {
        return amountPaid;
    }

    // Manually added setter for 'amountPaid'
    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Manually added getter for 'amountDue'
    public int getAmountDue() {
        return amountDue;
    }

    // Manually added setter for 'amountDue'
    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }

    // Manually added getter for 'currency'
    public String getCurrency() {
        return currency;
    }

    // Manually added setter for 'currency'
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Manually added getter for 'status'
    public String getStatus() {
        return status;
    }

    // Manually added setter for 'status'
    public void setStatus(String status) {
        this.status = status;
    }

    // Manually added getter for 'attempts'
    public int getAttempts() {
        return attempts;
    }

    // Manually added setter for 'attempts' - This was the method the compiler couldn't find
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    // Add other fields from the successful Razorpay API response as needed
    // If you add new fields, you will need to manually add their getters/setters here as well
    // until your Lombok setup is fixed.
}
