package com.example.springdataforum.Constans;

public enum TypesOfGas {
    GASOLINE(0), DIESEL(1), ELECTRIC(2), HYBRID(3);
    private int type;

    TypesOfGas(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
