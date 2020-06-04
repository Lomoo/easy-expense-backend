package com.example.sully.Expense.controller;


import com.example.sully.Expense.model.Expense;
import com.example.sully.Expense.model.Income;
import com.example.sully.Expense.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;




    @GetMapping("/incomes/{user_id}")
    List<Income> getAllUserIncomes (@PathVariable UUID user_id) {
        return incomeRepository.findByUserUUID(user_id);
    }

    @GetMapping("/incomes/{id}/{user_id}")
    ResponseEntity<?> getUserIncome (@PathVariable Long id, @PathVariable UUID user_id) {
        Optional<Income> income = incomeRepository.findById(id);

        if (income.get().checkUserId(user_id)){
            return          income.map(
                    response -> ResponseEntity.ok().body(response))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/incomes/{id}/{user_id}")
    ResponseEntity<?> deleteIncome(@PathVariable Long id, @PathVariable UUID user_id){

        if(incomeRepository.findById(id).get().checkUserId(user_id)){
            incomeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }
    @PutMapping("/incomes/update/{id}/{user_id}")
    ResponseEntity<Income> updateIncome (@Valid @RequestBody Income income, @PathVariable Long id, @PathVariable UUID user_id){
        if(!incomeRepository.findById(id).get().checkUserId(user_id)){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Income result = incomeRepository.save(income);
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/incomes")
    ResponseEntity<Income> createIncome(@Valid @RequestBody Income income) throws URISyntaxException{
        Income result = incomeRepository.save(income);
        return ResponseEntity.created(new URI("/api/incomes" + result.getId())).body(result);
    }


}
