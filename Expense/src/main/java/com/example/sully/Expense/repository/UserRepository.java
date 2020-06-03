package com.example.sully.Expense.repository;

import com.example.sully.Expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user_entity  WHERE Id =?1", nativeQuery = true)
    List<User> findByUserUUID(UUID user_entity_id);
}
