package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
// https://stackoverflow.com/questions/56583423/generating-equals-hashcode-implementation-but-without-a-call-to-superclass-even
@EqualsAndHashCode(callSuper = true)
@Table(name="student")
public class Student extends User {
    int academicYear;
    int semester;
    float GPA;
    int deptRank;

    @ManyToMany
    List<CourseOffering> followingCourses = new ArrayList<CourseOffering>();

}
