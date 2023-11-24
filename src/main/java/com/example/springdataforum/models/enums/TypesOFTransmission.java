package com.example.springdataforum.models.enums;

public enum TypesOFTransmission {
    MANUAL(0), AUTOMATIC(1);
    private int type;

    TypesOFTransmission(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
