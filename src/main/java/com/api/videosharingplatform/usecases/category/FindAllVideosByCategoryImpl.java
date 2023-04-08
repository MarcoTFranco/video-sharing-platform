package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllVideosByCategoryImpl implements FindAllVideosByCategory {

    private CategoryRepository categoryRepository;

    private VideoRepository videoRepository;

    public FindAllVideosByCategoryImpl(CategoryRepository categoryRepository, VideoRepository videoRepository) {
        this.categoryRepository = categoryRepository;
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideosByCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        return category.getVideos();
    }

    @Override
    public Page<Video> getAllVideosByCategoryPage(Long id, Pageable pageable) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        var page = videoRepository.findAllByCategoryTitle(category.getTitle(), pageable);
        return page;
    }
}
