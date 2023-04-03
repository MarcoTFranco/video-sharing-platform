package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindVideoByTitleCategoryImpl implements FindVideoByTitleCategory{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Video> getVideoByTitleCategory(String title) {

        Category category = categoryRepository.findByTitle(title)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return category.getVideos();
    }
}
