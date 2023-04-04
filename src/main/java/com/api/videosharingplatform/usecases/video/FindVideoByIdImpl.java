package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class FindVideoByIdImpl implements FindVideoById {

    private VideoRepository videoRepository;

    public FindVideoByIdImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video getVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException(id));
        return video;
    }
}
