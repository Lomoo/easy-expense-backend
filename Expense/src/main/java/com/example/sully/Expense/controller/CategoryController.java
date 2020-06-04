package com.example.sully.Expense.controller;


import com.example.sully.Expense.model.Category;
import com.example.sully.Expense.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="https://easy-expense-client.herokuapp.com")
public class CategoryController {

    private CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories(){
        return categoryRepository.findAll();
        //This get method is basically saying select * from category
    }
    //what about category/2?
    //path variable
    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id){
        //optional means it might not return anything
        //This line is going to return the category given the ID, we use optional because it may not return anything
        //meaning we get an ID that has no category (id not valid)
        Optional<Category> category = categoryRepository.findById(id);
        //if there is something we can use map to map the response a an OK response, and give back the body
        //otherwise we create a new response entity that is a not found http response
        return  category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    //expecting valid request body
    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException{
        Category result=categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/category/"+result.getId())).body(result);
        //equal to insert into the table...
    }

    //overwriting category
    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){

        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

