package com.demo.gateway.dao.interfaces;

import com.demo.gateway.model.interfaces.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface RetailerServiceDao {
    List<Transaction> getTransactionsForDates(LocalDate startDate, LocalDate endDate);
}
