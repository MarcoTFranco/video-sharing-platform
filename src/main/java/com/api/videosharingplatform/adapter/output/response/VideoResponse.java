package com.api.videosharingplatform.adapter.output.response;

import com.api.videosharingplatform.domain.entities.Video;

public class VideoResponse {

    private final String title;

    private final String description;

    private final String url;

    private final String idCategory;

    public VideoResponse(Video video) {
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();
        this.idCategory = video.getCategory().getId().toString();
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

    public String getIdCategory() {
        return idCategory;
    }
}
