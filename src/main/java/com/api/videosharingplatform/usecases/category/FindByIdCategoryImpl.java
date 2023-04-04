package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindByIdCategoryImpl implements FindByIdCategory {

    private final CategoryRepository categoryRepository;

    public FindByIdCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return category;
    }
}
