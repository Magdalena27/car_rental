package com.example.car_rental.Repositories;

import com.example.car_rental.Entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
