package com.example.bookmycar;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
class CarController {

    @GetMapping("/cars")
    public List<String> getCars() {
        return Arrays.asList("Benz", "Ferrari", "McLaren");
    }

    @PostMapping("/book")
    public String bookCar(@RequestParam String car) {
        return "Car " + car + " booked successfully!";
    }
}