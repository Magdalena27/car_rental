package com.example.car_rental.Entities;

import com.example.car_rental.Entities.Car;

import javax.persistence.*;

@Entity
public class CarImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carImageID;
    private String url;
    @OneToOne
    @JoinColumn(name = "carID")
    private Car car;
}
