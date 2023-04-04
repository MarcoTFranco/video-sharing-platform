package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindVideoByTitleCategoryImpl implements FindVideoByTitleCategory{

    private final CategoryRepository categoryRepository;

    public FindVideoByTitleCategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Video> getVideoByTitleCategory(String title) {

        Category category = categoryRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return category.getVideos();
    }
}
