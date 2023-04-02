package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateVideoImpl implements UpdateVideo {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video changeVideoFields(Long id, VideoRequest videoRequest) {
        Video video = videoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateVideo(video, videoRequest);
        videoRepository.save(video);
        return video;
    }

    private void updateVideo(Video video, VideoRequest videoRequest) {
        video.setTitle(videoRequest.getTitle());
        video.setDescription(videoRequest.getDescription());
        video.setUrl(videoRequest.getUrl());
    }
}
