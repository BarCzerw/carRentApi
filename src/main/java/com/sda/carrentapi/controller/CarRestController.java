package com.sda.carrentapi.controller;

import com.sda.carrentapi.manager.CarManager;
import com.sda.carrentapi.model.Car;
import com.sda.carrentapi.utility.errormessage.SuccessMessage;
import com.sda.carrentapi.utility.exception.CarAlreadyRented;
import com.sda.carrentapi.utility.exception.CarNotFound;
import com.sda.carrentapi.utility.exception.CarNotRented;
import com.sda.carrentapi.utility.errormessage.ErrorMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarManager carManager;

    public CarRestController(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping("/all")
    public List<Car> getAvailableCars() {
        return carManager.getAvailableCars();
    }

    @GetMapping("/forRent")
    public List<Car> getUnrentedCars() {
        return carManager.getUnrentedCars();
    }

    @PostMapping("/rent/{id}")
    public String rentCar(@PathVariable long id) {
        try {
            carManager.rentCar(id);
            return SuccessMessage.rentSuccessful(id);
        } catch (CarNotFound carNotFound) {
            return ErrorMessage.carNotFound(id);
        } catch (CarAlreadyRented carAlreadyRented) {
            return ErrorMessage.carAlreadyRented(id);
        }
    }

    @PostMapping("/return/{id}")
    public String returnCar(@PathVariable long id) {
        try {
            carManager.returnCar(id);
            return SuccessMessage.returnSuccessful(id);
        } catch (CarNotFound carNotFound) {
            return ErrorMessage.carNotFound(id);
        } catch (CarNotRented carNotRented) {
            return ErrorMessage.carNotRented(id);
        }
    }
}
