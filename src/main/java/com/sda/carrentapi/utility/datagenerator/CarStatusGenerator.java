package com.sda.carrentapi.utility.datagenerator;

import com.sda.carrentapi.model.CarStatus;

import java.util.Random;

public class CarStatusGenerator {

    public static CarStatus generate() {
        Random random = new Random();
        CarStatus carStatus = new CarStatus();

        carStatus.setAvailable(random.nextBoolean());

        if (carStatus.isAvailable()) {
            carStatus.setRented(random.nextBoolean());
        } else {
            carStatus.setRented(false);
        }

        return carStatus;
    }

}
