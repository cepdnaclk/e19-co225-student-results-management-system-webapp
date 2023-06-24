package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.AssesmentDTO;
import com.academetrics.academetrics.Entity.Assesment;
import com.academetrics.academetrics.Repository.AssesmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssesmentService {

    private final AssesmentRepository assesmentRepository;

    @Autowired
    public AssesmentService(AssesmentRepository assesmentRepository) {
        this.assesmentRepository = assesmentRepository;
    }

    public AssesmentDTO saveAssesment(AssesmentDTO assesmentDTO) {
        Assesment assesment = new Assesment();
        assesment.setType(assesmentDTO.getType());
        assesment.setMax_marks(assesmentDTO.getMax_marks());

        assesmentRepository.save(assesment);
        return assesmentDTO;
    }

    public Iterable<Assesment> getAllAssesments() {
        return assesmentRepository.findAll();
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
