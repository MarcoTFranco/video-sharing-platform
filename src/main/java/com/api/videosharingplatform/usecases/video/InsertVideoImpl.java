package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertVideoImpl implements InsertVideo {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video createVideo(VideoRequest videoRequest) {
        Video video = videoRequest.toModel();
        videoRepository.save(video);
        return video;
    }
}
