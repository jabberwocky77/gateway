package com.demo.gateway.model.data;

import com.demo.gateway.model.interfaces.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CustomerRewards {
    private String customerID;
    private Map<Integer, Integer> rewardPtsByMonth;
    private int totalRewardPts;

    public CustomerRewards(String customerID, List<Transaction> transactionList) {
        this.customerID = customerID;
        rewardPtsByMonth = new HashMap<>();
        // group rewards by month
        Map<Integer, List<Purchase>> transactionsByMonth = transactionList.stream().collect(groupingBy(Purchase::getMonth));
        // iterate over each month and perform calculations
        transactionsByMonth.forEach((k, v) -> {
            int month = k;
            // add up all spent
            double spent = v.stream().map(Purchase::getTransactionAmount).mapToDouble(Double::doubleValue).sum();
            // calculate reward pts
            int highPts = 0;
            int lowPts = 0;

            if (spent > 100) {
                highPts = ((int) spent - 100) * 2;
            }

            if (spent > 50) {
                if (spent >= 100) {
                    lowPts = 50;
                } else {
                    lowPts = (int) spent - 50;
                }
            }
            // group amounts by month
            int totalPts = lowPts + highPts;
            rewardPtsByMonth.put(month, totalPts);
            totalRewardPts += totalPts;
        });
    }

    /**
     * @param month 0-11
     * @return reward points for requested month
     */
    public int getPointsByMonth(int month) {
        return rewardPtsByMonth.get(month) == null ? 0 : rewardPtsByMonth.get(month);
    }

    /**
     *
     * @return total reward pts for customer
     */
    public int getTotalRewardPts() {
        return this.totalRewardPts;
    }

    /**
     *
     * @return customerID
     */
    public String getCustomerID() {
        return this.customerID;
    }
}
