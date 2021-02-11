package com.example.car_rental;

import com.example.car_rental.Controllers.CarApi;
import com.example.car_rental.Controllers.CustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomersController {

    @Autowired
    CustomerApi customerApi;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerApi.getAll());
        return "customers.html";
    }
}
