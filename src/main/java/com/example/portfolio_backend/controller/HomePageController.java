package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.dto.HomeDto;
import com.example.portfolio_backend.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/home")
public class HomePageController {
    @Autowired
    private HomeService homeService;
    @PostMapping
    public ResponseEntity insertHomeDetails(@RequestBody  HomeDto data)
    {
        return new ResponseEntity(homeService.insertHomeDetails(data),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity GetAllHomeDetails()
    {
        return new ResponseEntity(homeService.getAllHomeDetails(),HttpStatus.OK);
    }
}
