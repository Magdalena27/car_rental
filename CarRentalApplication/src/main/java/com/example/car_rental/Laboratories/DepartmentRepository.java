package com.example.car_rental.Laboratories;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Iterable<Department> findByDeptName(String deptName);

}