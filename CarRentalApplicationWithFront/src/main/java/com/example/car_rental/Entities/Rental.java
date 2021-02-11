package com.example.car_rental.Entities;

import com.example.car_rental.Entities.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalID;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private LocalDate returnExtension;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="customerID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="carID")
    private Car car;

    public Long getRentalID() {
        return rentalID;
    }

    public void setRentalID(Long rentalID) {
        this.rentalID = rentalID;
    }

//    public Long getCarID() {
//        return carID;
//    }
//
//    public void setCarID(Long carID) {
//        this.carID = carID;
//    }

//    public Long getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(Long customerID) {
//        this.customerID = customerID;
//    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getReturnExtension() {
        return returnExtension;
    }

    public void setReturnExtension(LocalDate returnExtension) {
        this.returnExtension = returnExtension;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID=" + rentalID +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", returnExtension=" + returnExtension +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}
