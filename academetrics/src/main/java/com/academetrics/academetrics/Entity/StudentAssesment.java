package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentAssesment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_user_name")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "assesment_id")
    private Assesment assesment;

    private String marks;
}
