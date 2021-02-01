package com.example.car_rental.Managers;

import com.example.car_rental.Entities.Customer;
import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Repositories.CustomerRepository;
import com.example.car_rental.Repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerManager {

    private final CustomerRepository customerRepository;
//    private final RentalRepository rentalRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
//        this.rentalRepository = rentalRepository;
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

//    public Optional<Customer> findPasswordById(Long customerID) {
//        return findById(customerID);
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @PostConstruct
//    public void CustomerManager() {
//        Customer customer = new Customer();
//        customer.setName("Zbigniew");
//        customer.setSurname("Porzycz");
//        customer.setAge(50);
//        customer.setEmail("zbigniewporzycz@mojapoczta.pl");
//        customer.setPhoneNumber(666666666);
//        customer.setLogin("admin");
//        customer.setPassword(passwordEncoder().encode("admin"));
//        customer.setEnabled(1);
//        customer.setRole("ADMIN");
//        customerRepository.save(customer);

//        Rental rental = new Rental();
//        rental.setCustomer(customer);
//        rental.setRentalDate(LocalDate.now());
//        rental.setReturnDate(LocalDate.of(2021, 2, 1));
//        rentalRepository.save(rental);

//        Customer customer2 = new Customer();
//        customer2.setName("Anna");
//        customer2.setSurname("Nowak");
//        customer2.setAge(30);
//        customer2.setEmail("annanowak@mojapoczta.pl");
//        customer2.setPhoneNumber(603603603);
//        customer2.setLogin("anna");
//        customer2.setPassword(passwordEncoder().encode("annanowak"));
//        customer2.setEnabled(1);
//        customer2.setRole("USER");
//        customerRepository.save(customer2);

//        Rental rental2 = new Rental();
//        rental2.setCustomer(customer2);
//        rental2.setRentalDate(LocalDate.now());
//        rental2.setReturnDate(LocalDate.of(2021, 2, 2));
//        rentalRepository.save(rental2);
//
//        Iterable<Customer> nowaks = customerRepository.findCustomerBySurname("Nowak");
////        Customer nowak = nowaks.iterator().next();
//
//        for (Customer cust: nowaks) {
//            System.out.println(cust);
//        }
//
 //   }

}
