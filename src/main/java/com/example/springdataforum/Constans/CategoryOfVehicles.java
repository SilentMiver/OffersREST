package com.example.springdataforum.Constans;

public enum CategoryOfVehicles {
    Car(0), Buss(1), Truck(2), Motorcycle(3);
    private int type;


    CategoryOfVehicles(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
