package com.example.car_rental;

import com.example.car_rental.Controllers.CarApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    CarApi carApi;

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carApi.getAll());
        return "cars.html";
    }
}
