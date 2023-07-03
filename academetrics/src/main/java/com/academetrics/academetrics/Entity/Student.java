package com.academetrics.academetrics.Entity;

import com.academetrics.academetrics.Globals;
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
//    @Transient
    private Double gpa = null;
    private Double targetGpa = null;
//    @Transient
//    private Integer deptRank;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCourse> followingCourses = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentAssesment> assesments = new ArrayList<>();

    @PostLoad
    public void postLoad() {
        calculateGPA();
    }

    @PostUpdate
    public void postUpdate(){
        calculateGPA();
    }

//    @PostPersist
//    public void postPersist(){
//        calculateGPA();
//    }

    public void calculateGPA(){
        double sumCiGi = 0.0;
        double sumCi = 0.0;

        for (StudentCourse studentCourse : this.followingCourses){
            String currGrade = studentCourse.getGrade();

            if (currGrade != null){
                sumCiGi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits() * Globals.gpaOfGrade.get(currGrade);
                sumCi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits();
            }
        }
        this.gpa = sumCiGi / sumCi;
        this.gpa = Math.round(this.gpa * 100.0) / 100.0;
    }


//    public void calculateDeptRank(){
//
//    }

    public int getTotalCredits(){
       int totalCredits = 0;

       if (!this.followingCourses.isEmpty()){
           for (StudentCourse studentCourse : this.followingCourses){
               totalCredits += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits();
           }
       }

       return totalCredits;
    }

    public void addCourse(CourseOffering courseOffering){
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudent(this);
        studentCourse.setCourseOffering(courseOffering);
        studentCourse.setGrade(null);
        followingCourses.add(studentCourse);
    }

    public boolean addCourseGrade(CourseOffering courseOffering, String grade){
        for (StudentCourse studentCourse : this.followingCourses){
            if (studentCourse.getCourseOffering() == courseOffering){
                studentCourse.setGrade(grade);
                // recalculate gpa
                calculateGPA();
                return true;
            }
        }
        return false;
    }
}