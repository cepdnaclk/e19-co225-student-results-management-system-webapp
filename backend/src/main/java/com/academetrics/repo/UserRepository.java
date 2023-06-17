package com.academetrics.repo;

import com.academetrics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// JPA Repository extend CRUD providing some additional functions

public interface UserRepository extends JpaRepository<User, Integer> {

}
