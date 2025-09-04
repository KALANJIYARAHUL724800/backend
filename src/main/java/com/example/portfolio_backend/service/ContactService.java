package com.example.portfolio_backend.service;
import com.example.portfolio_backend.dto.ContactDto;
import com.example.portfolio_backend.entity.Contact;
import com.example.portfolio_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public Contact createContact(ContactDto data)
    {
        Contact contact = new Contact();
        contact.setUserName(data.getUserName());
        contact.setEmail(data.getEmail());
        contact.setMessage(data.getMessage());
        return contactRepository.save(contact);
    }
    public List<Contact> getAllContactDetails()
    {
        return contactRepository.findAll();
    }
}