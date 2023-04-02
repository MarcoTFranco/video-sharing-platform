package com.api.videosharingplatform.adapter.input.request;

import com.api.videosharingplatform.domain.entities.Video;
import jakarta.validation.constraints.NotBlank;

public class VideoRequest {

    @NotBlank(message = "Titule is mandatory")
    private String title;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Url is mandatory")
    private String url;

    @Deprecated
    public VideoRequest() {
    }

    public VideoRequest(@NotBlank String title,
                        @NotBlank String description,
                        @NotBlank String url) {
        this.title = title;
        this.description = description;
        this.url = url;
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

    public Video toModel() {
        return new Video(title, description, url);
    }
}
