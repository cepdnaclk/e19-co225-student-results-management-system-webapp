package com.academetrics.controller;

import com.academetrics.dto.CourseDTO;
import com.academetrics.entity.Course;
import com.academetrics.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addNewCourse") // Map ONLY POST Requests
    public String addNewCourse(@RequestBody CourseDTO courseDTO) {
        courseService.saveCourse(courseDTO);
        return "Course Saved";
    }

    @GetMapping("/showAllCourses")
    public @ResponseBody Iterable<Course> getAllCourses() {
        //returns a JSON or XML with the courses
        return courseService.getAllCourses();
    }

}
