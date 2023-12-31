package com.example.database.tables.dbConnection.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCategories(){
        return categoryService.getCategories();
    }
}
