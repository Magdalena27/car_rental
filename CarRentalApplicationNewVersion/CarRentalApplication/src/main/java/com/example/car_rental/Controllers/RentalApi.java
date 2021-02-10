package com.example.car_rental.Controllers;

import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Managers.RentalManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rentals")
public class RentalApi {

        private RentalManager rentalManager;

        @Autowired
        public RentalApi(RentalManager rentalManager){
            super();
            this.rentalManager = rentalManager;
        }

        @GetMapping("/all")
        public Iterable<Rental> getAll(){
            return rentalManager.findAll();
        }

        @GetMapping("/id")
        public Optional<Rental> getRentalById(@RequestParam Long id){
            return rentalManager.findById(id);
        }

        @PostMapping("/save")
        public Rental addRental(@RequestBody Rental rental){
            return rentalManager.save(rental);
        }

        @DeleteMapping("/del")
        public void deleteRentalById(@RequestParam Long id){
            rentalManager.deleteById(id);
        }


}
