package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class AssesmentId implements Serializable {
    private String name;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_code", referencedColumnName = "course_code"),
            @JoinColumn(name = "year", referencedColumnName = "year")
    })
    private CourseOffering courseOffering;
}
