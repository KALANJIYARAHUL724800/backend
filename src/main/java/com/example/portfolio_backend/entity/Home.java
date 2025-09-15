package com.example.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio_data")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(name = "content", columnDefinition = "TEXT")
    private String contents;
    @CreationTimestamp()
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp()
    private LocalDate updatedAt;
}
