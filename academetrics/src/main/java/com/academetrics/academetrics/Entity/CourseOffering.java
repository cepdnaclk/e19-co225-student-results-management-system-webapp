package com.academetrics.academetrics.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
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

    @EmbeddedId
    private CourseOfferingId courseOfferingId;

    @ManyToOne
    @JoinColumn(name = "join_course_id")
    private Course course;

    // Getters and Setters

    public String getCode() {
        return courseOfferingId.getCode();
    }

    public void setCode(String code) {
        courseOfferingId.setCode(code);
    }

    public Integer getYear() {
        return courseOfferingId.getYear();
    }

    public void setYear(Integer year) {
        courseOfferingId.setYear(year);
    }

    public CourseOfferingId getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(CourseOfferingId courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
