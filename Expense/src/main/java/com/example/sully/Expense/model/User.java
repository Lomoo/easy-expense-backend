package com.example.sully.Expense.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
//TO MAKE JPA HAPPY SO WE DONT NEED CONSTRURCTOR
@NoArgsConstructor
@Entity
@Data
//Tells JPA to create a new db table with name user
@Table(name="user_entity")
public class User {

    @Id
    private UUID id;

    //One user can have many categories, like one user can have travel expenses, groceries, etc
    //Use set because it's a collection that does not contain duplicate elements
//    @OneToMany
//    private Set<Category> category;
//
}
