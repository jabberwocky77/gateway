package com.demo.gateway;

import static org.assertj.core.api.Assertions.assertThat;

import com.demo.gateway.model.data.CustomerRewards;
import com.demo.gateway.model.interfaces.Transaction;
import com.demo.gateway.service.impl.RetailerServiceImpl;
import com.demo.gateway.service.interfaces.RetailerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RetailerServiceTests {
    private RetailerService retailerService;
    private String customerID;
    private String transactionID;

    @BeforeEach
    public void setup() {
        retailerService = new RetailerServiceImpl();
        customerID = "123456";
        transactionID = "0000057";
    }

    @Test
    public void testByTransaction() {
        Transaction transaction = retailerService.getTransactionById(transactionID);
        assertThat(transaction).isNotNull();
    }

    @Test
    public void testByCustomer() {
        List<Transaction> transactionList = retailerService.getTransactionsByCustomerID(customerID);
        assertThat(transactionList).isNotEmpty();
    }

    @Test
    public void testByRewards() {
        List<Transaction> transactionList = retailerService.getTransactionsByCustomerID(customerID);
        assertThat(transactionList).isNotEmpty();
        List<CustomerRewards> rewardsList = retailerService.getCustomerRewards(transactionList);
        assertThat(rewardsList).isNotEmpty();
    }

}
