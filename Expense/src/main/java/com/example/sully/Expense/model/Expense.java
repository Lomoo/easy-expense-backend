package com.example.sully.Expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Table(name="expense")
public class Expense {

    @Id
    private Long id;

    private Instant expensedate;

    private String description;

    private double expenseAmount;


    @ManyToOne
    //Multiple expenses can only be under 1 category
    private Category category;


    @ManyToOne
    private User user_entity;

    public boolean checkUserId(UUID user_id){
        return user_id.equals(user_entity.getId());
    }
}
