package com.sda.carrentapi.utility.datagenerator;


import com.sda.carrentapi.model.Car;

public class CarDataGenerator {

    public static Car generate() {

        Car car = new Car();

        car.setManufacturer(CarManufacturerGenerator.generate());
        car.setModel(CarModelGenerator.generate());
        car.setProductionYear(CarProductionYearGenerator.generate());
        car.setCarStatus(CarStatusGenerator.generate());

        return car;
    }

}
