package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindByIdVideoImpl implements FindByIdVideo {

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }
}
