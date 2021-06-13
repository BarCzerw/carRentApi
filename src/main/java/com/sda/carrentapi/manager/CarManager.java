package com.sda.carrentapi.manager;

import com.sda.carrentapi.dto.CarDTO;
import com.sda.carrentapi.model.Car;
import com.sda.carrentapi.repository.CarRepository;
import com.sda.carrentapi.utility.exception.CarAlreadyRented;
import com.sda.carrentapi.utility.exception.CarNotFound;
import com.sda.carrentapi.utility.exception.CarNotRented;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarManager {

    CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCars() {
        return getAllCars().stream().filter(car -> car.getCarStatus().isAvailable()).collect(Collectors.toList());
    }

    public List<Car> getUnrentedCars() {
        return getAvailableCars().stream().filter(car -> !car.getCarStatus().isRented()).collect(Collectors.toList());
    }

    public CarDTO getCarById(long id) throws CarNotFound {
        Optional<Car> carById = carRepository.findById(id);
        if (carById.isPresent()) {
            return new CarDTO(carById.get());
        } else {
            throw new CarNotFound();
        }
    }

    public void rentCar(long id) throws CarNotFound, CarAlreadyRented {
        CarDTO carDTO = getCarById(id);
        if (!carDTO.getCarStatus().isRented()) {
            editCarRentStatus(id, true);
        } else {
            throw new CarAlreadyRented();
        }
    }

    public void returnCar(long id) throws CarNotFound, CarNotRented {
        CarDTO carDTO = getCarById(id);
        if (carDTO.getCarStatus().isRented()) {
            editCarRentStatus(id, false);
        } else {
            throw new CarNotRented();
        }
    }

    private void editCarRentStatus(long id, boolean newRentStatus) throws CarNotFound {
        CarDTO carDTO = getCarById(id);
        carDTO.getCarStatus().setRented(newRentStatus);
        carRepository.save(new Car(carDTO));
    }
}
