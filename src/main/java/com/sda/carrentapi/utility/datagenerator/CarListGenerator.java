package com.sda.carrentapi.utility.datagenerator;

import com.sda.carrentapi.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarListGenerator {

    public List<Car> generateCarList(int size) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            carList.add(generateSingleCar());
        }
        return carList;
    }

    private Car generateSingleCar() {
        return CarDataGenerator.generate();
    }

}
