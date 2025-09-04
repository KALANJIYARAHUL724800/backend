package com.example.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",length = 20)
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "message")
    private String message;
    @CreationTimestamp   // Auto set when record is created
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp     // Auto update when record is updated
    private LocalDateTime updatedAt;
}
