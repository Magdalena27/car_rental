package com.example.car_rental;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
     @GetMapping("/about")
     public String about(){
        return "about";
    }
     @GetMapping("/cars")
     public String cars(){
        return "cars";
    }
}
