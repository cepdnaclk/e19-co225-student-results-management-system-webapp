package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCourse {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "student_user_name")
        private Student student;

        @ManyToOne
        @JoinColumns({
                @JoinColumn(name = "course_offering_course_code", referencedColumnName = "course_code"),
                @JoinColumn(name = "course_offering_year", referencedColumnName = "year")
        })
        private CourseOffering courseOffering;

        private String grade;

        // Getters and setters
}
