package com.demo.gateway.service.interfaces;

import com.demo.gateway.model.data.Purchase;

import java.util.Date;
import java.util.List;

public interface RetailerService {
    Purchase getTransactionById(String transactionID);

    List<Purchase> getTransactionsByDate(Date startDate, Date endDate);

    List<Purchase> getTransactionsByCustomerID(String customerID);

}
