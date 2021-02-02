package com.example.car_rental.Managers;

import com.example.car_rental.Entities.Car;
import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Entities.StatusOfCar;
import com.example.car_rental.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class CarManager {

    private final CarRepository carRepository;

    @Autowired
    public CarManager(CarRepository carRepository) {
        super();
        this.carRepository = carRepository;
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }

    public Iterable<Car> findAll(){
        return carRepository.findAll();
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }

    public Iterable<Car> findByStatus(StatusOfCar.carStatus status) {
        return carRepository.findByStatus(status);
    }

    public Iterable<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public Iterable<Car> findByModel(String model) {
        return carRepository.findByModel(model);
    }

    public Iterable<Car> findByProductionYear(Integer productionYear) {
        return carRepository.findByProductionYear(productionYear);
    }

    public Iterable<Car> findCarsMoreExpensiveThan(Float rentalPrice) {
        return carRepository.findCarsMoreExpensiveThan(rentalPrice);
    }

    @PostConstruct
    public void CarManager() {
    Car car = new Car();
    car.setBrand("BMW");
    car.setColor("white");
    car.setModel("X6");
    car.setEngineCapacity(2000);
    car.setEngineType("diesel");
    car.setProductionYear(2020);
    car.setRentPrice(600.03f);
    car.setStatus(StatusOfCar.carStatus.AVAILABLE);
    carRepository.save(car);
    }
}
