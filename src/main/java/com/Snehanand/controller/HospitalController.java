package com.Snehanand.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HospitalController {

    @GetMapping("/")
    public String home() {
        return "HMPSJF Backend Running";
    }
}