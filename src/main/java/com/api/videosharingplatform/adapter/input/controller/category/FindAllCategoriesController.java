package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.usecases.category.FindAllCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllCategoriesController {
    @Autowired
    private FindAllCategories findAllCategories;


    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = findAllCategories.getAllCategory()
                .stream()
                .map(CategoryResponse::new)
                .toList();
        return ResponseEntity.ok().body(categories);
    }
}
