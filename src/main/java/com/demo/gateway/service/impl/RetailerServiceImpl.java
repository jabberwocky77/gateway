package com.demo.gateway.service.impl;

import com.demo.gateway.model.data.Purchase;
import com.demo.gateway.service.interfaces.RetailerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RetailerServiceImpl implements RetailerService {
    @Override
    public Purchase getTransactionById(String transactionID) {
        return null;
    }

    @Override
    public List<Purchase> getTransactionsByDate(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<Purchase> getTransactionsByCustomerID(String customerID) {
        return null;
    }
}
