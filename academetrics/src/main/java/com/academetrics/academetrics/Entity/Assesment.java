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
 private Integer assesId; // eg: assesment id
 private String type; // eg: lab/project/mid/quiz/tutorial/assignment
 private Integer max_marks; // Out of Total( x% ) eg: 10

  @ManyToOne
  @JoinColumns({
          @JoinColumn(name = "course_code", referencedColumnName = "course_code"),
          @JoinColumn(name = "year", referencedColumnName = "year")
  })
  private CourseOffering courseOffering;

 }
