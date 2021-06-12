package com.sda.carrentapi.dto;

import com.sda.carrentapi.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Long id;
    private String manufacturer;
    private String model;
    private String productionYear;
    private boolean isAvailable;
    private boolean isRented;

    public CarDTO(Car car) {
        setByCar(car);
    }

    public void setByCar(Car car) {
        this.id = car.getId();
        this.manufacturer = car.getManufacturer();
        this.model = car.getModel();
        this.productionYear = car.getProductionYear();
        this.isAvailable = car.isAvailable();
        this.isRented = car.isRented();
    }
}
