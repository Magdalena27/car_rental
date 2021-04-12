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

    /*PostConstruct
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

    Car car2 = new Car();
    car2.setBrand("Lexus");
    car2.setColor("white");
    car2.setModel("RX");
    car2.setEngineCapacity(3500);
    car2.setEngineType("hybrid");
    car2.setProductionYear(2020);
    car2.setRentPrice(670.02f);
    car2.setStatus(StatusOfCar.carStatus.AVAILABLE);
    carRepository.save(car2);

    Car car3 = new Car();
    car3.setBrand("BMW");
    car3.setColor("gray");
    car3.setModel("X3");
    car3.setEngineCapacity(2500);
    car3.setEngineType("diesel");
    car3.setProductionYear(2017);
    car3.setRentPrice(470.03f);
    car3.setStatus(StatusOfCar.carStatus.AVAILABLE);
    carRepository.save(car3);

    Car car4 = new Car();
    car4.setBrand("Mercedes");
    car4.setColor("black");
    car4.setModel("S63");
    car4.setEngineCapacity(5500);
    car4.setEngineType("petrol");
    car4.setProductionYear(2019);
    car4.setRentPrice(580.33f);
    car4.setStatus(StatusOfCar.carStatus.AVAILABLE);
    carRepository.save(car4);

    Car car5 = new Car();
    car5.setBrand("Porshe");
    car5.setColor("red");
    car5.setModel("Panamera");
    car5.setEngineCapacity(4000);
    car5.setEngineType("diesel");
    car5.setProductionYear(2017);
    car5.setRentPrice(770.55f);
    car5.setStatus(StatusOfCar.carStatus.AVAILABLE);
    carRepository.save(car5);*/

    //}


}
