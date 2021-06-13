package com.sda.carrentapi.controller;


import com.sda.carrentapi.manager.CarManagerAdministrative;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/admin")
public class CarAdminRestController {

    CarManagerAdministrative carManagerAdministrative;

    public CarAdminRestController(CarManagerAdministrative carManagerAdministrative) {
        this.carManagerAdministrative = carManagerAdministrative;
    }

    @PostConstruct
    public void generateRandomCarData() {
        carManagerAdministrative.generateRandomData();
    }

}
