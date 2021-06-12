package com.sda.carrentapi.model;

import com.sda.carrentapi.dto.CarDTO;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String manufacturer;
    @NotNull
    private String model;
    @NotNull
    private String productionYear;
    @NotNull
    private boolean isAvailable;
    @NotNull
    private boolean isRented;

    public Car() {
    }

    public Car(CarDTO carDTO) {
        setByDTO(carDTO);
    }

    public void setByDTO(CarDTO carDTO) {
        this.id = carDTO.getId();
        this.manufacturer = carDTO.getManufacturer();
        this.model = carDTO.getModel();
        this.productionYear = carDTO.getProductionYear();
        this.isAvailable = carDTO.isAvailable();
        this.isRented = carDTO.isRented();
    }

}
