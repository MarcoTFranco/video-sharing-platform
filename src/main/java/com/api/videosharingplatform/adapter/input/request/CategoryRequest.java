package com.api.videosharingplatform.adapter.input.request;

import com.api.videosharingplatform.domain.entities.Category;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Colour is mandatory")
    private String colour;

    @Deprecated
    public CategoryRequest() {
    }

    public CategoryRequest(@NotBlank String title,
                           @NotBlank String colour) {
        this.title = title;
        this.colour = colour;
    }

    public String getTitle() {
        return title;
    }

    public String getColour() {
        return colour;
    }

    public Category toModel() {
        return new Category(this.title, this.colour);
    }
}
