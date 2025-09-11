package com.example.portfolio_backend.controller;

import com.example.portfolio_backend.dto.ContactDto;
import com.example.portfolio_backend.dto.MessageInfoDto;
import com.example.portfolio_backend.service.ContactService;
import com.example.portfolio_backend.service.MessageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private MessageInfoService messageInfoService;

    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto data)
    {
        MessageInfoDto email = new MessageInfoDto();
        email.setUserName(data.getUserName());
        email.setEmail(data.getEmail());
        email.setMessage(data.getMessage());
        messageInfoService.sendEmail(email);
        return new ResponseEntity(contactService.createContact(data), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity createContact()
    {
        return new ResponseEntity(contactService.getAllContactDetails(), HttpStatus.OK);
    }
}