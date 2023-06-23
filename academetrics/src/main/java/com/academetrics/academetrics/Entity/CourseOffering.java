package com.academetrics.academetrics.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseOffering {
    // check composite key
    @Id
    private String code; // eg: GP106
    private int year;    // eg: 2021

    // many- one map to course
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course ;


}
