package com.example.car_rental;

import com.example.car_rental.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {

    private CustomerManager customerManager;

    @Autowired
    public CustomerApi(CustomerManager customerManager){
        this.customerManager = customerManager;
    }

    @GetMapping("/all")
    public Iterable<Customer> getAll(){
        return customerManager.findAll();
    }

    @GetMapping("/id")
    public Optional<Customer> getCustomerById(@RequestParam Long id){
        return customerManager.findById(id);
    }

    @PostMapping("/save")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerManager.save(customer);
    }

    @DeleteMapping("/del")
    public void deleteCustomerById(@RequestParam Long id){
        customerManager.deleteById(id);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerManager.update(customer);
    }
}
