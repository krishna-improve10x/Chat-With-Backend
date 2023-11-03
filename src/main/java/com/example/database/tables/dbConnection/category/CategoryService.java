package com.example.database.tables.dbConnection.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDatabaseManager dbManager;
    public List<String> getCategories(){
        return dbManager.getCategories();
    }
}
