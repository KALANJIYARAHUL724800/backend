package com.example.portfolio_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String userName,email,message;
    public void getDatas(ContactDto data)
    {
        System.out.println(data.getUserName());
    }
}
