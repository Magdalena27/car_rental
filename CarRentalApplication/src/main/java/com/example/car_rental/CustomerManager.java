package com.example.car_rental;

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
public class CustomerManager {

    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, RentalRepository rentalRepository) {
        super();
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }

    public Iterable<Customer> findCustomerBySurname(String surname) {
        return customerRepository.findCustomerBySurname(surname);
    }

    @PostConstruct
    public void CustomerManager() {
        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Kowalski");
        customer.setAge(40);
        customer.setEmail("jankowalski@mojapoczta.pl");
        customer.setPhoneNumber(502515502);
        customer.setLogin("jan");
        customer.setPassword("jankowalski");
        customerRepository.save(customer);

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setRentalDate(LocalDate.now());
        rental.setReturnDate(LocalDate.of(2021, 2, 1));
        rentalRepository.save(rental);

        Customer customer2 = new Customer();
        customer2.setName("Anna");
        customer2.setSurname("Nowak");
        customer2.setAge(30);
        customer2.setEmail("annanowak@mojapoczta.pl");
        customer2.setPhoneNumber(603603603);
        customer2.setLogin("anna");
        customer2.setPassword("annanowak");
        customerRepository.save(customer2);

        Rental rental2 = new Rental();
        rental2.setCustomer(customer2);
        rental2.setRentalDate(LocalDate.now());
        rental2.setReturnDate(LocalDate.of(2021, 2, 2));
        rentalRepository.save(rental2);
//
//        Iterable<Customer> nowaks = customerRepository.findCustomerBySurname("Nowak");
////        Customer nowak = nowaks.iterator().next();
//
//        for (Customer cust: nowaks) {
//            System.out.println(cust);
//        }
//
    }

}
