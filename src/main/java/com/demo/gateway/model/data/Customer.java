package com.demo.gateway.model.data;

import com.demo.gateway.model.interfaces.Entity;
import com.demo.gateway.types.EntityType;

// started this class, but I guess that's going too deep for the current requirement, data structure does not provide for this data
public class Customer implements Entity {
    private String customerID;
    private String nameLast;
    private String nameFirst;

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    @Override
    public void setID(String ID) {
        setCustomerID(ID);
    }

    @Override
    public String getID() {
        return getCustomerID();
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

    @Override
    public EntityType getEntityType() {
        return EntityType.CUSTOMER;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }
}
