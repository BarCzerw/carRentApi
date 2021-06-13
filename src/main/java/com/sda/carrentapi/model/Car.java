package com.sda.carrentapi.model;

import com.sda.carrentapi.dto.CarDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer productionYear;
    @Embedded
    private CarStatus carStatus;

    public Car(CarDTO carDTO) {
        setByDTO(carDTO);
    }

    public void setByDTO(CarDTO carDTO) {
        this.id = carDTO.getId();
        this.manufacturer = carDTO.getManufacturer();
        this.model = carDTO.getModel();
        this.productionYear = carDTO.getProductionYear();
        this.carStatus = carDTO.getCarStatus();
    }

}
