package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.domain.entities.Video;

public interface FindVideoById {

    Video getVideo(Long id);

}
