package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.domain.entities.Video;

public interface UpdateVideo {

    Video changeVideoFields(Long id, VideoRequest videoRequest);

}
