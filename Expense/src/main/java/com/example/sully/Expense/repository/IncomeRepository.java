package com.example.sully.Expense.repository;

import com.example.sully.Expense.model.Expense;
import com.example.sully.Expense.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IncomeRepository extends JpaRepository<Income, Long> {


    //    @Query(value = "SELECT * FROM expense WHERE user_entity_id = ?1")
    @Query(value = "SELECT * FROM income WHERE user_entity_id =?1", nativeQuery = true)
    List<Income> findByUserUUID(UUID user_entity_id);

}
