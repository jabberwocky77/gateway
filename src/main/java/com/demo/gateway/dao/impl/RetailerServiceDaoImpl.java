package com.demo.gateway.dao.impl;

import com.demo.gateway.GatewayApplication;
import com.demo.gateway.dao.interfaces.RetailerServiceDao;
import com.demo.gateway.model.data.Purchase;
import com.demo.gateway.model.interfaces.Transaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import java.util.List;

@Repository
public class RetailerServiceDaoImpl implements RetailerServiceDao {

    public List<Transaction> getTransactionsForDates(LocalDate startDate, LocalDate endDate) {
        // read dataset from json resource
        ClassPathResource resource = new ClassPathResource("/custData.json", GatewayApplication.class);
        try (InputStream inputStream = resource.getInputStream()) {
            String string = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();

            Transaction[] transactions = gson.fromJson(string, Purchase[].class);

            // return with provided date constraint
            return Arrays.stream(transactions)
                    .filter(t -> {
                        // convert to locadate
                        LocalDate trDate = t.getTransactionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        // compare to provided date constraint
                        return (trDate.isEqual(startDate) || trDate.isAfter(startDate)) && (trDate.isEqual(endDate) || trDate.isBefore(endDate));
                    }).toList();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
