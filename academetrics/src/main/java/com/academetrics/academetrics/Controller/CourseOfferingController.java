package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.CourseOfferingId;
import com.academetrics.academetrics.Service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course-offering")
@CrossOrigin
public class CourseOfferingController {

    @Autowired
    private CourseOfferingService courseOfferingService;

     //Insert new Course Offering
    @PostMapping("/") // Map ONLY POST Requests
    public String addNewCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO) {
        courseOfferingService.saveCourseOffering(courseOfferingDTO);
        return "Course Offering Saved";
    }


    //  Show All Course Offerings
    @GetMapping("/") // Map only GET Requests
    public @ResponseBody List<CourseOfferingDTO> getAllCourseOfferings() {
        //returns a JSON or XML with the courses
        return courseOfferingService.getAllCourseOfferings();
    }

    //  Update a Course Offering
//    @PutMapping("/") // Map only PUT Requests
//    public String updateCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO) {
//    //returns a JSON or XML with the courses
//         courseOfferingService.updateCourseOffering(courseOfferingDTO.getCode(), courseOfferingDTO);
//         return "Course Offering Updated";
//    }

    @DeleteMapping("/")
    public String deleteCourseOffering(@RequestBody CourseOfferingDTO courseOfferingDTO){
        // check composite key for Course code and year
        courseOfferingService.deleteCourseOffering(courseOfferingDTO);
        return "Course Offering Deleted Successfully";
    }

}


