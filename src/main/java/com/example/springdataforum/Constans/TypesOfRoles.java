package com.example.springdataforum.Constans;

public enum TypesOfRoles {
    USER(0), ADMIN(1);
    private int type;

    TypesOfRoles(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
