package com.example.car_rental.Managers;

import com.example.car_rental.Entities.Car;
import com.example.car_rental.Entities.Customer;
import com.example.car_rental.Entities.Rental;
import com.example.car_rental.Entities.StatusOfCar;
import com.example.car_rental.Repositories.CarRepository;
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
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, RentalRepository rentalRepository, CarRepository carRepository) {
        super();
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
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

    public Optional<Customer> findPasswordById(Long customerID) {
        return findById(customerID);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

@PostConstruct
    public void CustomerManager() {
        Customer customer = new Customer();
        customer.setName("Zbigniew");
        customer.setSurname("Porzycz");
        customer.setAge(50);
        customer.setEmail("zbigniewporzycz@mojapoczta.pl");
        customer.setPhoneNumber(666666666);
        customer.setLogin("admin");
        customer.setPassword(passwordEncoder().encode("admin"));
        customer.setEnabled(1);
        customer.setRole("ROLE_ADMIN");
        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setName("Anna");
        customer2.setSurname("Nowak");
        customer2.setAge(30);
        customer2.setEmail("annanowak@mojapoczta.pl");
        customer2.setPhoneNumber(603603603);
        customer2.setLogin("anna");
        customer2.setPassword(passwordEncoder().encode("annanowak"));
        customer2.setEnabled(1);
        customer2.setRole("ROLE_USER");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setName("Andrzej");
        customer3.setSurname("Kowalik");
        customer3.setAge(40);
        customer3.setEmail("andrzejkowalik@mojapoczta.pl");
        customer3.setPhoneNumber(669669669);
        customer3.setLogin("andrzej");
        customer3.setPassword(passwordEncoder().encode("andrzejkowalik"));
        customer3.setEnabled(1);
        customer3.setRole("ROLE_USER");
        customerRepository.save(customer3);

        Customer customer4 = new Customer();
        customer4.setName("Katarzyna");
        customer4.setSurname("Nowak");
        customer4.setAge(35);
        customer4.setEmail("katarzynanowak@mojapoczta.pl");
        customer4.setPhoneNumber(668668668);
        customer4.setLogin("katarzyna");
        customer4.setPassword(passwordEncoder().encode("katarzynanowak"));
        customer4.setEnabled(1);
        customer4.setRole("ROLE_USER");
        customerRepository.save(customer4);

        Customer customer5 = new Customer();
        customer5.setName("Agata");
        customer5.setSurname("Rykowska");
        customer5.setAge(45);
        customer5.setEmail("agatarykowska@mojapoczta.pl");
        customer5.setPhoneNumber(667667667);
        customer5.setLogin("agata");
        customer5.setPassword(passwordEncoder().encode("agatarykowska"));
        customer5.setEnabled(1);
        customer5.setRole("ROLE_USER");
        customerRepository.save(customer5);

        Car car = new Car();
        car.setBrand("BMW");
        car.setColor("white");
        car.setModel("X6");
        car.setEngineCapacity(2000);
        car.setEngineType("diesel");
        car.setProductionYear(2020);
        car.setRentPrice(600.03f);
        car.setStatus(StatusOfCar.carStatus.AVAILABLE);
        carRepository.save(car);

        Car car2 = new Car();
        car2.setBrand("Lexus");
        car2.setColor("white");
        car2.setModel("RX");
        car2.setEngineCapacity(3500);
        car2.setEngineType("hybrid");
        car2.setProductionYear(2020);
        car2.setRentPrice(670.02f);
        car2.setStatus(StatusOfCar.carStatus.AVAILABLE);
        carRepository.save(car2);

        Car car3 = new Car();
        car3.setBrand("BMW");
        car3.setColor("gray");
        car3.setModel("X3");
        car3.setEngineCapacity(2500);
        car3.setEngineType("diesel");
        car3.setProductionYear(2017);
        car3.setRentPrice(470.03f);
        car3.setStatus(StatusOfCar.carStatus.AVAILABLE);
        carRepository.save(car3);

        Car car4 = new Car();
        car4.setBrand("Mercedes");
        car4.setColor("black");
        car4.setModel("S63");
        car4.setEngineCapacity(5500);
        car4.setEngineType("petrol");
        car4.setProductionYear(2019);
        car4.setRentPrice(580.33f);
        car4.setStatus(StatusOfCar.carStatus.AVAILABLE);
        carRepository.save(car4);

        Car car5 = new Car();
        car5.setBrand("Porshe");
        car5.setColor("red");
        car5.setModel("Panamera");
        car5.setEngineCapacity(4000);
        car5.setEngineType("diesel");
        car5.setProductionYear(2017);
        car5.setRentPrice(770.55f);
        car5.setStatus(StatusOfCar.carStatus.AVAILABLE);
        carRepository.save(car5);


        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setCar(car);
        rental.setRentalDate(LocalDate.now());
        rental.setReturnDate(LocalDate.of(2021, 2, 22));
        rental.setReturnExtension(LocalDate.of(2021, 2, 25));
        rentalRepository.save(rental);

        Rental rental2 = new Rental();
        rental2.setCustomer(customer2);
        rental2.setCar(car2);
        rental2.setRentalDate(LocalDate.now());
        rental2.setReturnDate(LocalDate.of(2021, 2, 15));
        rental2.setReturnExtension(LocalDate.of(2021, 2, 20));
        rentalRepository.save(rental2);

        Rental rental3 = new Rental();
        rental3.setCustomer(customer3);
        rental3.setCar(car3);
        rental3.setRentalDate(LocalDate.of(2021, 2, 22));
        rental3.setReturnDate(LocalDate.of(2021, 2, 25));
        rental3.setReturnExtension(LocalDate.of(2021, 2, 28));
        rentalRepository.save(rental3);

        Rental rental4 = new Rental();
        rental4.setCustomer(customer4);
        rental4.setCar(car4);
        rental4.setRentalDate(LocalDate.of(2021, 3, 10));
        rental4.setReturnDate(LocalDate.of(2021, 3, 11));
        rental4.setReturnExtension(LocalDate.of(2021, 3, 13));
        rentalRepository.save(rental4);

        Rental rental5 = new Rental();
        rental5.setCustomer(customer5);
        rental5.setCar(car5);
        rental5.setRentalDate(LocalDate.of(2021, 3, 12));
        rental5.setReturnDate(LocalDate.of(2021, 3, 14));
        rental5.setReturnExtension(LocalDate.of(2021, 3, 15));
        rentalRepository.save(rental5);


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
