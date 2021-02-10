package com.example.car_rental.Repositories;

import com.example.car_rental.Entities.Car;
import com.example.car_rental.Entities.StatusOfCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Iterable<Car> findByStatus(StatusOfCar.carStatus status);

    Iterable<Car> findByBrand(String brand);

    Iterable<Car> findByModel(String model);

    Iterable<Car> findByProductionYear(Integer productionYear);

    @Query("SELECT c FROM Car c WHERE c.rentPrice > ?1")
    Iterable<Car> findCarsMoreExpensiveThan(Float rentPrice);
}
