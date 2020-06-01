package com.example.sully.Expense.repository;

import com.example.sully.Expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

//    @Query(value = "SELECT * FROM expense WHERE user_entity_id = ?1")
    @Query(value = "SELECT * FROM expense WHERE user_entity_id =?1", nativeQuery = true)
    List<Expense> findByUserUUID(UUID user_entity_id);

    @Query(value = "SELECT * FROM expense WHERE user_entity_id =?1 AND category_id =?2", nativeQuery = true)
    List<Expense> findUserExpenseByCategoryId(UUID user_entity_id, Long category_id);
//    List<Expense> findByUserUUID();

}
