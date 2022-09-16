package com.demo.gateway.service.impl;

import com.demo.gateway.dao.impl.RetailerServiceDaoImpl;
import com.demo.gateway.dao.interfaces.RetailerServiceDao;
import com.demo.gateway.model.data.CustomerRewards;
import com.demo.gateway.model.interfaces.Transaction;
import com.demo.gateway.service.interfaces.RetailerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class RetailerServiceImpl implements RetailerService {
    RetailerServiceDao dao;

    public RetailerServiceImpl() {
        dao = new RetailerServiceDaoImpl();
    }

    @Override
    public Transaction getTransactionById(String transactionID) {
        return getThreeMonthBulk()
                .stream()
                .filter(t-> t.getTransactionID().equals(transactionID))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Transaction> getTransactionsForThreeMonths() {
       return getThreeMonthBulk();
    }

    @Override
    public List<Transaction> getTransactionsByCustomerID(String customerID) {
        return getThreeMonthBulk()
                .stream()
                .filter(t -> t.getCustomerID().equals(customerID))
                .toList();
    }

    /**
     *
     * @param transactions
     * @return list of customer specific CustomerReward objects
     */
    @Override
    public List<CustomerRewards> getCustomerRewards(List<Transaction> transactions) {

        List<CustomerRewards> customerRewards = new ArrayList<>();
        // process rewards, group lists by customer, then create customer specific rewards objects
        Map<String, List<Transaction>> groupedTransactions = transactions.stream().collect((groupingBy(Transaction::getCustomerID)));
        groupedTransactions.forEach((k,v)-> {
            customerRewards.add(new CustomerRewards(k, v));
        });

        return customerRewards;
    }


    private List<Transaction> getThreeMonthBulk() {
        // hard coding dates for this exercise
        LocalDate dt1 = LocalDate.of(2022, 1, 1);
        LocalDate dt2 = LocalDate.of(2022, 3, 31);
        return dao.getTransactionsForDates(dt1,dt2);
    }
}
