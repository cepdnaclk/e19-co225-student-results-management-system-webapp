package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.CourseDTO;
import com.academetrics.academetrics.Entity.Course;
import com.academetrics.academetrics.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/course")
@CrossOrigin
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

    // Insert new Course Offering
    @PostMapping("/") // Map ONLY POST Requests
    public String addNewCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO) {
        courseOfferingService.saveCourseOffering(courseOfferingDTO);
        return "Course Offering Saved";
    }


    //  Show All Course Offerings
    @GetMapping("/") // Map only GET Requests
    public @ResponseBody Iterable<Course> getAllCourseOfferings() {
        //returns a JSON or XML with the courses
        return courseOfferingService.getAllCourseOfferings();
    }

    //  Update a Course Offering
    @PutMapping("/") // Map only PUT Requests
    public String updateCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO) {
    //returns a JSON or XML with the courses
         courseOfferingService.updateCourseOffering(courseOfferingDTO);
         return "Course Offering Updated";
    }

    @DeleteMapping("/")
    public String deleteCourseOffering(@RequestParam String Code){

        return CouurseOfferingService.deleteUser(Code);
    }

}


