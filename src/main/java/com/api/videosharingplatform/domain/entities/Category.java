package com.api.videosharingplatform.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Colour is mandatory")
    private String colour;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

    @Deprecated
    public Category() {
    }
    public Category(@NotBlank String title,
                    @NotBlank String colour) {
        this.title = title;
        this.colour = colour;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getColour() {
        return colour;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }
}
