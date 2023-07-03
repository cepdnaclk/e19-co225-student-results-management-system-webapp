package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.AssesmentDTO;
import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import com.academetrics.academetrics.Entity.Assesment;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Repository.AssesmentRepository;
import com.academetrics.academetrics.Repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssesmentService {

    private final AssesmentRepository assesmentRepository;
    private CourseOfferingService courseOfferingService;

    @Autowired
    public AssesmentService(AssesmentRepository assesmentRepository, CourseOfferingService courseOfferingService) {

        this.assesmentRepository = assesmentRepository;
        this.courseOfferingService = courseOfferingService;
    }

    public AssesmentDTO saveAssesment(AssesmentDTO assesmentDTO) {
        Assesment assesment = new Assesment();
        assesment.setType(assesmentDTO.getType());
        assesment.setName(assesmentDTO.getName());
        assesment.setMax_marks(assesmentDTO.getMax_marks());
        assesment.setCourseOffering(courseOfferingService.CourseOfferingDTOtoEntity(assesmentDTO.getCourseOfferingDTO()));

        assesmentRepository.save(assesment);
        return assesmentDTO;
    }

    public Iterable<Assesment> getAllAssesments(CourseOfferingDTO courseOfferingDTO) {
        CourseOffering courseOffering = courseOfferingService.CourseOfferingDTOtoEntity(courseOfferingDTO);
        return assesmentRepository.findAllByCourseOffering(courseOffering);
    }

    public Assesment getAssesment(Integer id){
        return assesmentRepository.findByAssesId(id);
    }

    public AssesmentDTO updateAssesment(Integer assesmentId, AssesmentDTO updatedAssesmentDTO) {
        Assesment existingAssesment = assesmentRepository.findByAssesId(assesmentId);
        if (existingAssesment != null) {
            existingAssesment.setType(updatedAssesmentDTO.getType());
            existingAssesment.setMax_marks (updatedAssesmentDTO.getMax_marks ());

            assesmentRepository.save(existingAssesment);
        } else {
            throw new RuntimeException("Assesment not found with id: " + assesmentId);
        }
        return updatedAssesmentDTO;
    }

    public void deleteAssesment(Integer assesmentId) {
        assesmentRepository.deleteByAssesId(assesmentId);
    }

}
