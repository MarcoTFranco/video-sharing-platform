package com.api.videosharingplatform.adapter.output.response;

import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryResponse {

    private String title;

    private String colour;

    private List<VideoResponse> videos;

    public CategoryResponse(Category category) {
        this.title = category.getTitle();
        this.colour = category.getColour();
        this.videos = category.getVideos().stream()
                .map(VideoResponse::new)
                .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public String getColour() {
        return colour;
    }

    public List<VideoResponse> getVideos() {
        return videos;
    }
}
