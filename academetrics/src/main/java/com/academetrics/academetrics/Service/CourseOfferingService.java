package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.CourseDTO;
import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import com.academetrics.academetrics.Entity.Course;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.CourseOfferingId;
import com.academetrics.academetrics.Repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;

    @Autowired
    public CourseOfferingService(CourseOfferingRepository courseOfferingRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
    }

    public List<CourseOfferingDTO> getAllCourseOfferings() {
        List<CourseOfferingDTO> courseOfferings = new ArrayList<CourseOfferingDTO>();
        for (CourseOffering courseOffering : courseOfferingRepository.findAll()){
            CourseOfferingDTO courseOfferingDTO = new CourseOfferingDTO();
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCode(courseOffering.getCourseOfferingId().getCourse().getCode());
            courseDTO.setName(courseOffering.getCourseOfferingId().getCourse().getName());
            courseDTO.setCredits(courseOffering.getCourseOfferingId().getCourse().getCredits());
            courseOfferingDTO.setCourse(courseDTO);
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
//    public void deleteCourseOffering(CourseOfferingId courseOfferingId) {
//        courseOfferingRepository.deleteByCodeAndYear(courseOfferingId);
//    }

}
