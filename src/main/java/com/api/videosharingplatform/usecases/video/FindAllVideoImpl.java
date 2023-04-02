package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FindAllVideoImpl implements FindAllVideo {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Optional<Video> getVideo(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return video;
    }
}
