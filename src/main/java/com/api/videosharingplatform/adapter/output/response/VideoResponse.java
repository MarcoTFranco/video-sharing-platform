package com.api.videosharingplatform.adapter.output.response;

import com.api.videosharingplatform.domain.entities.Video;

public class VideoResponse {

    private final String title;

    private final String description;

    private final String url;

    public VideoResponse(Video video) {
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
