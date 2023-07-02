package com.academetrics.academetrics.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
public class CourseOfferingId implements Serializable {
//    @Column(name = "code")
//    private String code;
    @ManyToOne
    @JoinColumn(name = "course_code")
    private Course course;

    @Column(name = "year")
    private Integer year;

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

