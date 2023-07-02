package com.teho.springinflearn.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long course_id;

    private int price;

    @CreatedDate
    private LocalDateTime enroll_date;
}
