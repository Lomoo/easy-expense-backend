package com.example.sully.Expense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Data
@Table(name="income")
public class Income {

        @Id
        private Long id;

        private Double income;

        private String description;



        @ManyToOne
        private User user_entity;

        public boolean checkUserId(UUID user_id){
                return user_id.equals(user_entity.getId());
        }
}

