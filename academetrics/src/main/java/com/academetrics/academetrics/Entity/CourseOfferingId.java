package com.academetrics.academetrics.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
public class CourseOfferingId implements Serializable {
//    @Column(name = "code")
//    private String code;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_code")
    private Course course;

    @Column(name = "year")
    private Integer year;

    public CourseOfferingId() {
    }

    public CourseOfferingId(Course course, Integer year) {
        this.course = course;
        this.year = year;
    }

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

