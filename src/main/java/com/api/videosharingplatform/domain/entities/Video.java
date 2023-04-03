package com.api.videosharingplatform.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Titule is mandatory")
    private String title;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Url is mandatory")
    private String url;
    @ManyToOne
    @NotNull(message = "Category is mandatory")
    private Category category;

    @Deprecated
    public Video() {
    }

    public Video(@NotBlank String title,
                 @NotBlank String description,
                 @NotBlank String url,
                 @NotNull @Valid Category category) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
