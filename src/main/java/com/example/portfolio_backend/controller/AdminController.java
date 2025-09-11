package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.dto.AdminDto;
import com.example.portfolio_backend.security.JwtUtil;
import com.example.portfolio_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<?> findAdmin(@RequestBody AdminDto data)
    {
        if(data==null)
        {
            return new ResponseEntity("Data is not Found",HttpStatus.BAD_GATEWAY);
        }
        try {
            String username =  adminService.findUserAndPassword(data).getUsername();
            String token = JwtUtil.generateToken(username);
            Map<String,Object> response = new HashMap<>();
            response.put("token",token);
            response.put("username",username);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e)
        {
            return  new ResponseEntity<>("Invalid Credentials",HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping
    public ResponseEntity getAllDatas()
    {
        return new ResponseEntity(adminService.getAllDatas(),HttpStatus.OK);
    }
}
