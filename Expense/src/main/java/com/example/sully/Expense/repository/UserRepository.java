package com.example.sully.Expense.repository;

import com.example.sully.Expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
