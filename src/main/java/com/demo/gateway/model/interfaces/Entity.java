package com.demo.gateway.model.interfaces;

import com.demo.gateway.types.EntityType;

public interface Entity {
    void setID(String ID);

    String getID();

    String getNameLast();

    void setNameLast(String last);

    String getNameFirst();

    void setNameFirst(String nameFirst);

    EntityType getEntityType();
}
