package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.domain.entities.Video;

import java.util.Optional;

public interface FindAllVideo {

    Optional<Video> getVideo(Long id);

}
