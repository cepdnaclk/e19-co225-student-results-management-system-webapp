package com.academetrics.academetrics.Entity;

import jakarta.persistence.Entity;
import com.academetrics.academetrics.Entity.Assesment;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    private Long id;

    private String regNo;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assesment assessment;

    // Constructors
    public Result() {
    }

    public Result(Long id, String regNo, Grade grade) {
        this.id = id;
        this.regNo = regNo;
        this.grade = grade;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public Grade getGrade() {
        return grade;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

