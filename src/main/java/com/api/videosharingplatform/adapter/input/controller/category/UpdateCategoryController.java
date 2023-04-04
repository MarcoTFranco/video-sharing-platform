package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.usecases.category.UpdateCategory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCategoryController {
    @Autowired
    private UpdateCategory updateCategory;

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,
                                                           @RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = updateCategory.changeCategoryFields(id, categoryRequest);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }
}
