package com.demo.gateway.model.interfaces;

import com.demo.gateway.types.TransactionType;

import java.util.Date;

public interface Transaction {
    String getCustomerID();

    void setCustomerID(String customerID);

    void setTransactionID(String retailerTransactionID);

    String getTransactionID();

    Date getTransactionDate();

    void setTransactionDate(Date transactionDate);

    Double getTransactionAmount();

    void setTransactionAmount(Double transactionAmount);

    TransactionType getTransactionType();

    int getMonth();
}
