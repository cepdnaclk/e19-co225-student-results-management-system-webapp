package com.academetrics.academetrics.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseOfferingId implements Serializable {
    @Column(name = "code")
    private String code;

    @Column(name = "year")
    private Integer year;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

