package com.example.car_rental.Laboratories;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Iterable<Employee> findByLastName(String lastName);

    //@Query("SELECT e FROM Employee e where e.lastName LIKE ?1")
    //Iterable<Employee> findAllWhereName(String lastName);
}
