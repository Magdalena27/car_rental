package com.example.car_rental.Repositories;

import com.example.car_rental.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findCustomerBySurname(String surname);

}
