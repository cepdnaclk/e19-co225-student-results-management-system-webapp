package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.CourseDTO;
import com.academetrics.academetrics.DTO.UserDTO;
import com.academetrics.academetrics.Entity.Course;
import com.academetrics.academetrics.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Insert new Course
    @PostMapping("/") // Map ONLY POST Requests
    public String addNewCourse(@RequestBody CourseDTO courseDTO) {
        courseService.saveCourse(courseDTO);
        return "Course Saved";
    }


    //  Show All Courses
    @GetMapping("/") // Map only GET Requests
    public @ResponseBody Iterable<Course> getAllCourses() {
        //returns a JSON or XML with the courses
        return courseService.getAllCourses();
    }

    @GetMapping(value = "/", params = {"courseCode"})
    public CourseDTO getCourse(@RequestParam String courseCode){
        return courseService.getCourse(courseCode);
    }

    //  Update a Course
    @PutMapping("/") // Map only PUT Requests
    public String updateCourse(@RequestBody CourseDTO courseDTO) {
        //returns a JSON or XML with the courses
        courseService.updateCourse(courseDTO.getCode(),courseDTO);
        return "Course Updated";
    }

    // Delete a Course
    @DeleteMapping("/")
    public String deleteCourse(@RequestBody String Code){

        courseService.deleteCourse(Code);

        return "Course Deleted Succesfully";

    }

}


