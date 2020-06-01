package com.example.sully.Expense.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name="category")
public class Category {


    @Id
    private Long id;

    //@NonNull

    //Things like travel, grocery, etc
    private String name;



}
