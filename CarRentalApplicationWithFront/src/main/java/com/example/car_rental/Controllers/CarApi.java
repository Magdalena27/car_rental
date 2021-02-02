package com.example.car_rental.Controllers;

import com.example.car_rental.Entities.Car;
import com.example.car_rental.Entities.StatusOfCar;
import com.example.car_rental.Managers.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi(CarManager carManager) {
        super();
        this.carManager = carManager;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll(){
        return carManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Car> getCarById(@RequestParam Long id){
        return carManager.findById(id);
    }

    @PostMapping("/save")
    public Car addCar(@RequestBody Car car){
        return carManager.save(car);
    }

    @DeleteMapping("/del")
    public void deleteCarById(@RequestParam Long id){
        carManager.deleteById(id);
    }

    @GetMapping("/brand")
    public Iterable<Car> getCarByBrand(@RequestParam String brand) {
        return carManager.findByBrand(brand);
    }

    @GetMapping("/model")
    public Iterable<Car> getCarByModel(@RequestParam String model) {
        return carManager.findByModel(model);
    }

    @GetMapping("/status")
    public Iterable<Car> getCarByStatus(@RequestParam StatusOfCar.carStatus status) {
        return carManager.findByStatus(status);
    }

    @GetMapping("/prodYear")
    public Iterable<Car> getCatByProductionYear(@RequestParam Integer productionYear) {
        return carManager.findByProductionYear(productionYear);
    }

    @GetMapping("/moreExp")
    public Iterable<Car> getMoreExpensiveCarThan(@RequestParam Float rentalPrice) {
        return carManager.findCarsMoreExpensiveThan(rentalPrice);
    }
}
