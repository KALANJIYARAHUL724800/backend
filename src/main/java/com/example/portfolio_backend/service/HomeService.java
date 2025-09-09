package com.example.portfolio_backend.service;

import com.example.portfolio_backend.dto.HomeDto;
import com.example.portfolio_backend.entity.Home;
import com.example.portfolio_backend.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;
    public Home insertHomeDetails(HomeDto data)
    {
        Home homedata = new Home();
        homedata.setContents(data.getContents());
        return homeRepository.save(homedata);
    }
    public List<Home> getAllHomeDetails()
    {
        return homeRepository.findAll();
    }
}
