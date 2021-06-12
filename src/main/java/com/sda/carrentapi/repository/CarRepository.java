package com.sda.carrentapi.repository;

import com.sda.carrentapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
