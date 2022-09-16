package com.demo.gateway.rest;

import com.demo.gateway.model.data.CustomerRewards;
import com.demo.gateway.model.interfaces.Transaction;
import com.demo.gateway.service.interfaces.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailerController {
    @Autowired
    RetailerService service;

    @GetMapping("/retail/threemonths/rewards")
    public ResponseEntity<List<CustomerRewards>> getRewards() {
        // get raw transactions
        List<Transaction> transactions = service.getTransactionsForThreeMonths();
        // convert them to list of customer rewards specific to each customer
        List<CustomerRewards> customerRewards = service.getCustomerRewards(transactions);

        return new ResponseEntity<>(customerRewards, HttpStatus.OK);
    }

    @GetMapping("/retail/transaction/{transID}")
    public ResponseEntity<Transaction> getTransactionByID(@PathVariable String transID) {
        Transaction transaction = service.getTransactionById(transID);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/retail/customer/{custID}")
    public ResponseEntity<List<Transaction>> getCustomerTransactions(@PathVariable String custID) {
       List<Transaction> transaction = service.getTransactionsByCustomerID(custID);

       return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/retail/threemonths")
    public ResponseEntity<List<Transaction>> getTransactionsForThreeMonths() {
        List<Transaction> transactions = service.getTransactionsForThreeMonths();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
