package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindAllVideoImpl implements FindAllVideo {

    private VideoRepository videoRepository;

    public FindAllVideoImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }
}
