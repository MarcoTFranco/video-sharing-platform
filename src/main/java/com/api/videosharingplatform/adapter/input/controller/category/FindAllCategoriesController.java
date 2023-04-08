package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.output.response.CategoryResponse;
import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.category.FindAllCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllCategoriesController {
    @Autowired
    private FindAllCategories findAllCategories;


    @GetMapping(value = "/categories")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories( @PageableDefault(size = 5) Pageable pageable) {
        Page<CategoryResponse> page = findAllCategories.getAllCategoryPage(pageable)
                .map(CategoryResponse::new);
        return ResponseEntity.ok(page);
    }
}
