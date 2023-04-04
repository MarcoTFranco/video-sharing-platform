package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
public class UpdateCategoryImpl implements UpdateCategory {

    private final CategoryRepository categoryRepository;

    public UpdateCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category changeCategoryFields(Long id, CategoryRequest categoryRequest) {

        Assert.notNull(id, "Id cannot be null");
        Assert.isTrue(id != 1, "You can't change the default category");

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        updateData(category, categoryRequest);
        categoryRepository.save(category);
        return category;
    }

    private void updateData(Category category, CategoryRequest categoryRequest) {
        category.setTitle(categoryRequest.getTitle());
        category.setColour(categoryRequest.getColour());
    }
}
