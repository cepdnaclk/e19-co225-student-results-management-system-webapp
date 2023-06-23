package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Department;
import com.academetrics.academetrics.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
