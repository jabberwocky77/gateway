package com.demo.gateway.rest;

import com.demo.gateway.model.data.CustomerRewards;
import com.demo.gateway.model.data.Purchase;
import com.demo.gateway.model.interfaces.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailerController {

    @GetMapping("/transact/{transID}")
    public ResponseEntity<Transaction> getTransactionByID(@PathVariable String transID) {

        return null;
    }

    @GetMapping("/transact/{custID}")
    public ResponseEntity<List<Transaction>> getCustomerTransactions(@PathVariable String custID) {

        return null;
    }

    @GetMapping("/transact/threemonths")
    public ResponseEntity<List<Transaction>> getTransactionsForThreeMonths() {
        return null;
    }

    @GetMapping("/transact/threemonths/rewards")
    public ResponseEntity<List<CustomerRewards>> getRewards() {
        return null;
    }
}
