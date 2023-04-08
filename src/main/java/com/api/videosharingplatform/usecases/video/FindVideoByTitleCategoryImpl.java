package com.api.videosharingplatform.usecases.video;

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
public class FindVideoByTitleCategoryImpl implements FindVideoByTitleCategory {

    private final VideoRepository videoRepository;

    public FindVideoByTitleCategoryImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getVideoByTitleCategory(String title) {
        return videoRepository.findAllByCategoryTitle(title);
    }

    @Override
    public Page<Video> getVideoByTitleCategoryPage(String title, Pageable pageable) {
        var page = videoRepository.findAllByCategoryTitle(title, pageable);
        return page;
    }
}
