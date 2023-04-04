package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.usecases.category.InsertCategory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateCategoryController {

    @Autowired
    private InsertCategory insertCategory;

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = insertCategory.createCategory(categoryRequest);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }
}
