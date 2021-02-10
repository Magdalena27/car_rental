package com.example.car_rental.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;
    private String brand;
    private String model;
    private Integer engineCapacity;
    private String engineType;
    private String color;
    private Integer productionYear;
    private Float rentPrice;
    private StatusOfCar.carStatus status;

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public StatusOfCar.carStatus getStatus() {
        return status;
    }

    public void setStatus(StatusOfCar.carStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", engineType='" + engineType + '\'' +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                ", rentPrice=" + rentPrice +
                ", status=" + status +
                '}';
    }
}
