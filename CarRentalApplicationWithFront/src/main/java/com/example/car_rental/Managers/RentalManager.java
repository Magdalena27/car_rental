package com.example.car_rental.Managers;

import com.example.car_rental.Entities.Customer;
import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Repositories.CustomerRepository;
import com.example.car_rental.Repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class RentalManager {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalManager(RentalRepository rentalRepository) {
        super();
        this.rentalRepository = rentalRepository;
    }

    public Optional<Rental> findById(Long id){
        return rentalRepository.findById(id);
    }

    public Iterable<Rental> findAll(){
        return rentalRepository.findAll();
    }

    public Rental save(Rental rental){
        return rentalRepository.save(rental);
    }

    public void deleteById(Long id){
        rentalRepository.deleteById(id);
    }

}


