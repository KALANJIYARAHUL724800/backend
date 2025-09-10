package com.example.portfolio_backend.service;

import com.example.portfolio_backend.dto.AdminDto;
import com.example.portfolio_backend.entity.Admin;
import com.example.portfolio_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public Admin postAdminForm(AdminDto data)
    {
        Admin obj = new Admin();
        obj.setUsername(data.getUsername());
        obj.setPassword(data.getPassword());
        return adminRepository.save(obj);
    }
    public List<Admin> getAllDatas()
    {
        return adminRepository.findAll();
    }
    public Admin findUserAndPassword(AdminDto data)
    {
        return adminRepository.findByUsernameAndPassword(data.getUsername(), data.getPassword()).orElseThrow();
    }
}
