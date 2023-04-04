package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class InsertCategoryImpl implements InsertCategory {

    private final CategoryRepository categoryRepository;

    public InsertCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category createCategory(CategoryRequest categoryRequest) {
        Assert.notNull(categoryRequest, "CategoryRequest cannot be null");

        Category category = categoryRequest.toModel();
        categoryRepository.save(category);
        return category;
    }
}
