package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.CourseDTO;
import com.academetrics.academetrics.DTO.UserDTO;
import com.academetrics.academetrics.Entity.Course;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCode(courseDTO.getCode());
        course.setName(courseDTO.getName());
        course.setCredits(courseDTO.getCredits());
        // Set other properties manually if needed
        courseRepository.save(course);
        return courseDTO;
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseDTO getCourse(String courseCode) {
        Course course = new Course();
        course = courseRepository.findByCode(courseCode);
        return courseEntityToDTO(course);
    }

    public CourseDTO updateCourse(String courseCode, CourseDTO updatedCourseDTO) {
        Course existingCourse = courseRepository.findByCode(courseCode);
        if (existingCourse != null) {
            existingCourse.setName(updatedCourseDTO.getName());
            existingCourse.setCredits(updatedCourseDTO.getCredits());

            courseRepository.save(existingCourse); // save in the course repo
        }
        else {
            // handling the case where course is not found (courseCode == null)
            throw new RuntimeException("Course not found with code: " + courseCode);
        }
        return updatedCourseDTO;
    }
    public void deleteCourse(String courseCode) {
        courseRepository.deleteByCode(courseCode);
    }

    public CourseDTO courseEntityToDTO(Course course){
        if (course == null) return null;

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());
        courseDTO.setCredits(courseDTO.getCredits());

        return courseDTO;
    }
}
