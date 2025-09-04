package com.example.portfolio_backend.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.portfolio_backend.dto.MessageInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageInfoService {

    @Value("${spring.mail.username}")
    private String owner;

    private final JavaMailSender mailSender;

    public MessageInfoService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(MessageInfoDto message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
        String currentDateTime = now.format(formatter);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(owner);                   // your Gmail
        simpleMailMessage.setFrom(owner);                 // your Gmail
        simpleMailMessage.setReplyTo(message.getEmail()); // user's email

        // Capitalize only the first letter of the name
        String userName = message.getUserName();
        String capitalized = (userName == null || userName.isEmpty())
                ? userName
                : userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();

        simpleMailMessage.setSubject("New Portfolio Message From " + capitalized + " " + currentDateTime);
        simpleMailMessage.setText(message.getMessage());

        try {
            mailSender.send(simpleMailMessage);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // prints exact cause
        }
    }
}
