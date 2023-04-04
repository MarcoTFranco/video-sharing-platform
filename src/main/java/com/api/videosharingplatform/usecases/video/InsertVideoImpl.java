package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InsertVideoImpl implements InsertVideo {

    private VideoRepository videoRepository;

    private CategoryRepository categoryRepository;

    public InsertVideoImpl(VideoRepository videoRepository, CategoryRepository categoryRepository) {
        this.videoRepository = videoRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Video createVideo(VideoRequest videoRequest) {

        if (videoRequest.getCategoryId() == null) {
            videoRequest.setCategoryId(1L);
        }

        Category category = categoryRepository.findById(videoRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(videoRequest.getCategoryId()));

        Video video = videoRequest.toModel(category);
        videoRepository.save(video);
        return video;
    }
}
