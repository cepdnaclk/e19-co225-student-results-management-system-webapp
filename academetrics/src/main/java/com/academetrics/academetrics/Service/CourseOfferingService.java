package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.CourseDTO;
import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import com.academetrics.academetrics.Entity.Course;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.CourseOfferingId;
import com.academetrics.academetrics.Repository.CourseOfferingRepository;
import com.academetrics.academetrics.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;
    private CourseRepository courseRepository;

    @Autowired
    public CourseOfferingService(CourseOfferingRepository courseOfferingRepository, CourseRepository courseRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
        this.courseRepository = courseRepository;
    }

    public void saveCourseOffering(CourseOfferingDTO courseOfferingDTO) {
        // Convert the CourseOfferingDTO to a CourseOffering entity
        CourseOffering courseOffering = new CourseOffering();

        // Create a new CourseOfferingId and set its properties from the DTO
        CourseOfferingId courseOfferingId = new CourseOfferingId();
//        courseOfferingId.setCourse(courseOfferingDTO.getCoursDTO());
        courseOfferingId.setYear(courseOfferingDTO.getYear());
        courseOfferingId.setCourse(courseRepository.findByCode(courseOfferingDTO.getCourseDTO().getCode()));

        // Set the CourseOfferingId in the CourseOffering entity
        courseOffering.setCourseOfferingId(courseOfferingId);

        // Save the CourseOffering entity in the repository
        courseOfferingRepository.save(courseOffering);
    }
    public List<CourseOfferingDTO> getAllCourseOfferings() {
        List<CourseOfferingDTO> courseOfferings = new ArrayList<CourseOfferingDTO>();
        for (CourseOffering courseOffering : courseOfferingRepository.findAll()){
            CourseOfferingDTO courseOfferingDTO = new CourseOfferingDTO();
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCode(courseOffering.getCourseOfferingId().getCourse().getCode());
            courseDTO.setName(courseOffering.getCourseOfferingId().getCourse().getName());
            courseDTO.setCredits(courseOffering.getCourseOfferingId().getCourse().getCredits());
            courseOfferingDTO.setCourseDTO(courseDTO);
            courseOfferingDTO.setYear(courseOffering.getCourseOfferingId().getYear());
            courseOfferings.add(courseOfferingDTO);
        }
       return courseOfferings;
    }

//    public CourseOfferingDTO updateCourseOffering(String courseCode, CourseOfferingDTO updatedCourseOfferingDTO) {
//        CourseOffering existingCourseOffering = courseOfferingRepository.findByCode(courseCode);
//
//        if (existingCourseOffering != null) {
//            existingCourseOffering.setYear(updatedCourseOfferingDTO.getYear());
//
//            courseOfferingRepository.save(existingCourseOffering); // save in the course repo
//        }
//        else {
//         // handling the case where course Offering is not found (courseCode == null)
//            throw new RuntimeException("Course Offering not found with code: " + courseCode);
//        }
//        return updatedCourseOfferingDTO;
//    }
    public void deleteCourseOffering(CourseOfferingId courseOfferingId) {
        courseOfferingRepository.deleteByCourseOfferingId(courseOfferingId);
    }

}
