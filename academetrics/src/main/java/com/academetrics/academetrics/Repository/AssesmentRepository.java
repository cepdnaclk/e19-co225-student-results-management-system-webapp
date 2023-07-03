package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Assesment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssesmentRepository extends JpaRepository<Assesment, Integer> {

    Assesment findByAssesId(Integer id);
    void deleteByAssesId(Integer id);

}
