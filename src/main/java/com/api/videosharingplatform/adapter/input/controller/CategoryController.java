package com.api.videosharingplatform.adapter.input.controller;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.usecases.category.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private InsertCategory insertCategory;
    @Autowired
    private FindAllCategories findAllCategories;
    @Autowired
    private FindByIdCategory findByIdCategory;
    @Autowired
    private UpdateCategory updateCategory;
    @Autowired
    private DeleteCategory deleteCategory;
    @Autowired
    private FindAllVideosByCategory findAllVideosByCategory;

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = insertCategory.createCategory(categoryRequest);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = findAllCategories.getAllCategory()
                .stream()
                .map(CategoryResponse::new)
                .toList();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        Category category = findByIdCategory.getCategoryById(id);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,
                                                   @RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = updateCategory.changeCategoryFields(id, categoryRequest);
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        deleteCategory.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories/{id}/videos")
    public ResponseEntity<List<VideoResponse>> getAllVideosByCategory(@PathVariable Long id) {
        List<VideoResponse> list = findAllVideosByCategory.getAllVideosByCategory(id).stream()
                .map(VideoResponse::new).toList();
        return ResponseEntity.ok().body(list);
    }

}
