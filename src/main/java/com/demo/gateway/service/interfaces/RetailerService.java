package com.demo.gateway.service.interfaces;

import com.demo.gateway.model.data.CustomerRewards;
import com.demo.gateway.model.interfaces.Transaction;

import java.util.List;

public interface RetailerService {
    Transaction getTransactionById(String transactionID);

    List<Transaction> getTransactionsByCustomerID(String customerID);

    List<CustomerRewards> getCustomerRewards(List<Transaction> transactions);

    List<Transaction> getTransactionsForThreeMonths();

}
