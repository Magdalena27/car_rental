package com.example.car_rental.Repositories;

import com.example.car_rental.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findCustomerBySurname(String surname);

//    Optional<String> findPasswordById(Long customerID);

}
