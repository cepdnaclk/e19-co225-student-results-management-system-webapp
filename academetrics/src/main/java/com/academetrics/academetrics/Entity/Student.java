package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
//@Cascade(org.hibernate.annotations.CascadeType.DELETE)
@NoArgsConstructor
@AllArgsConstructor
@Data
// https://stackoverflow.com/questions/56583423/generating-equals-hashcode-implementation-but-without-a-call-to-superclass-even
@EqualsAndHashCode(callSuper = true)
@Table(name="student")
public class Student extends User {
    private int academicYear;
    private int semester;
    @Transient
    private double gpa;
    private Double targetGpa = null;
    private int deptRank;


//    @ManyToMany
//    private Map<CourseOffering, Assesment> followingCourses = new HashMap<CourseOffering, Assesment>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCourse> followingCourses = new ArrayList<>();

    @PostLoad
    public void calculateGPA() {
        Map<String, Double> gpaOfGrade = new HashMap<>();
        gpaOfGrade.put("A+", 4.0);
        gpaOfGrade.put("A", 4.0);
        gpaOfGrade.put("A-", 3.7);
        gpaOfGrade.put("B+", 3.3);
        gpaOfGrade.put("B", 3.0);
        gpaOfGrade.put("B-", 2.7);
        gpaOfGrade.put("C+", 2.3);
        gpaOfGrade.put("C", 2.0);
        gpaOfGrade.put("C-", 1.7);
        gpaOfGrade.put("D+", 1.3);
        gpaOfGrade.put("D", 1.8);
        gpaOfGrade.put("E", 0.0);

        double sumCiGi = 0.0;
        double sumCi = 0.0;

        for (StudentCourse studentCourse : this.followingCourses){
            String currGrade = studentCourse.getGrade();

            if (currGrade != null){
                sumCiGi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits() * gpaOfGrade.get(currGrade);
                sumCi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits();
            }
        }
        this.gpa = sumCiGi / sumCi;
        this.gpa = Math.round(this.gpa * 100.0) / 100.0;
    }


    public void addCourse(CourseOffering courseOffering){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(this);
        studentCourse.setCourseOffering(courseOffering);
        studentCourse.setGrade(null);
        followingCourses.add(studentCourse);
    }
}