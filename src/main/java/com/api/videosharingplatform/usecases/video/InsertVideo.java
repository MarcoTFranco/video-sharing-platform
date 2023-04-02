package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.domain.entities.Video;

public interface InsertVideo {
    Video createVideo(VideoRequest videoRequest);
}
