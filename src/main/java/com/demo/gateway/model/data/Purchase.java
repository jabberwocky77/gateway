package com.demo.gateway.model.data;

import com.demo.gateway.model.interfaces.Transaction;
import com.demo.gateway.types.TransactionType;

import java.util.Date;

public class Purchase implements Transaction {

    private String customerID;
    private String transactionID;

    private Date transactionDate;

    private Double transactionAmount;


    public Purchase() {

    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setTransactionID(String retailerTransactionID) {
        this.transactionID = retailerTransactionID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getMonth() {
        return this.transactionDate.getMonth();
    }

    public TransactionType getTransactionType() {
        return TransactionType.PURCHASE;
    }
}
