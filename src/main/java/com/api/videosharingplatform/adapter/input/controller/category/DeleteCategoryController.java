package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.usecases.category.DeleteCategoryById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCategoryController {

    @Autowired
    private DeleteCategoryById deleteCategoryById;

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        deleteCategoryById.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
