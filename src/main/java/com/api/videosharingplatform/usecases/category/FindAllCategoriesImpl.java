package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoriesImpl implements FindAllCategories{

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
