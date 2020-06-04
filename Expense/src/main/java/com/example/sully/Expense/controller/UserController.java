package com.example.sully.Expense.controller;


import com.example.sully.Expense.model.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sully.Expense.repository.UserRepository;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="https://easy-expense-client.herokuapp.com")
public class UserController {

    @Autowired
    private  UserRepository userRepository;

    @PostMapping("/users")
    ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {

         if(userRepository.findByUserUUID(user.getId()).size() == 0){
             User result = userRepository.save(user);
             return ResponseEntity.created(new URI("/api/users" + result.getId())).body(result);
         }else{
             return new ResponseEntity<>(HttpStatus.CONFLICT);
         }

    }

}
