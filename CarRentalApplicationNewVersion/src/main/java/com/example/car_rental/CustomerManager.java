package com.example.car_rental;

import com.example.car_rental.Entities.Car;
import com.example.car_rental.Entities.Customer;
import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Entities.StatusOfCar;
import com.example.car_rental.Repositories.CarImagesRepository;
import com.example.car_rental.Repositories.CarRepository;
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
    private final CarRepository carRepository;
    private final CarImagesRepository carImagesRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, RentalRepository rentalRepository, CarRepository carRepository,
                           CarImagesRepository carImagesRepository) {
        super();
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.carImagesRepository = carImagesRepository;
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

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }


    @PostConstruct
    public void runAtStart() {
        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Kowalski");
        customer.setAge(40);
        customer.setEmail("jankowalski@mojapoczta.pl");
        customer.setPhoneNumber(502515502);
        customer.setLogin("jan");
        customer.setPassword("jankowalski");

        customerRepository.save(customer);

        Car car = new Car();
        car.setBrand("BMW");
        car.setColor("red");
        car.setEngineCapacity(2000);
        car.setEngineType("Diesel");
        car.setModel("X4");
        car.setProductionYear(2014);
        car.setRentPrice(650.03f);
        car.setStatus(StatusOfCar.carStatus.AVAILABLE);

        carRepository.save(car);

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setRentalDate(LocalDate.now());
        rental.setReturnDate(LocalDate.of(2021, 2, 1));
        rental.setCar(car);

        rentalRepository.save(rental);
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
