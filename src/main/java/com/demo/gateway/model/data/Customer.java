package com.demo.gateway.model.data;


public class Customer {
    private String customerID;
    private String nameLast;
    private String nameFirst;

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }
}
