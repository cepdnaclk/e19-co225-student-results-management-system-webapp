package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Assesment;
import com.academetrics.academetrics.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssesmentRepository extends JpaRepository<Assesment, Integer> {

    Assesment findByid(Integer id);
    void deleteById(Integer id);

}
