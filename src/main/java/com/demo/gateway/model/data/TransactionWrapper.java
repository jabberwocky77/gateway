package com.demo.gateway.model.data;

import com.demo.gateway.model.interfaces.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.groupingBy;

public class TransactionWrapper {
    private List<CustomerRewards>  customerRewards;
    private List<Transaction> allTransactions;

    public TransactionWrapper(List<Transaction> transactions, boolean applyRewards) {
        this.allTransactions = transactions;
        if (applyRewards) {
            customerRewards = new ArrayList<>();
            // process rewards points
            Map<String, List<Transaction>> groupedTransactions = transactions.stream().collect((groupingBy(Transaction::getCustomerID)));
            groupedTransactions.forEach((k,v)-> {
                customerRewards.add(new CustomerRewards(k, v));
            });

        }
    }

    public List<CustomerRewards> getCustomerRewards() {
        return customerRewards;
    }

    public List<Transaction> getAllTransactions() {
        return allTransactions;
    }
}
