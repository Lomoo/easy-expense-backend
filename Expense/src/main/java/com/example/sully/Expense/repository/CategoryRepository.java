package com.example.sully.Expense.repository;

import com.example.sully.Expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//The 2nd argument is the type of our id, so in this case long
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //Given name find category associated with it
    //Syntax is like findBy + field but first letter is caps
    Category findByName(String name);

}
