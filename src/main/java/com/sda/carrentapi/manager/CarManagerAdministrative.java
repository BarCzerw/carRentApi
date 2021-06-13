package com.sda.carrentapi.manager;

import com.sda.carrentapi.dto.CarDTO;
import com.sda.carrentapi.model.Car;
import com.sda.carrentapi.repository.CarRepository;
import com.sda.carrentapi.utility.datagenerator.CarDataGenerator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Service
public class CarManagerAdministrative {

    private static final int CAR_DATA_SIZE = 40;

    private CarRepository carRepository;

    public CarManagerAdministrative(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void generateRandomData() {
        for (int i = 0; i < CAR_DATA_SIZE; i++) {
            carRepository.save(CarDataGenerator.generate());
        }
    }

    @PostMapping("/add")
    public void addCar(@RequestBody @Valid CarDTO carDTO) {
        carRepository.save(new Car(carDTO));
    }

}
