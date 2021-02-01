package com.example.car_rental.Repositories;

import com.example.car_rental.Entities.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Long> {
}

