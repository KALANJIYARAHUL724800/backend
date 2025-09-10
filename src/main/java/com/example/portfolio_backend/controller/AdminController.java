package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.dto.AdminDto;
import com.example.portfolio_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity findAdmin(@RequestBody AdminDto data)
    {
        if(data==null)
        {
            return new ResponseEntity("Data is not Found",HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity(adminService.findUserAndPassword(data),HttpStatus.OK);
    }
}
