package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.usecases.category.FindByIdCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindCategoryByIdController {
    @Autowired
    private FindByIdCategory findByIdCategory;

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        Category category = findByIdCategory.getCategoryById(id);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }
}
