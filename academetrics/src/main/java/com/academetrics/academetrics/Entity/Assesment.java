package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Assesment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // eg: assesment id
    private String type; // eg: lab/project/mid/quiz/tutorial/assignment
    private Integer max_marks; // Out of Total( x% ) eg: 10

    @ManyToOne
    @JoinColumn(name = "join_course_offering_id")
    private CourseOffering courseOffering;
}
