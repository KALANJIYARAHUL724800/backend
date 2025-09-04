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
@Data
@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pages")
    private String pages;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String contents;
    @CreationTimestamp()
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp()
    private LocalDate updatedAt;
}
