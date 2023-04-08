package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindVideoByTitleCategoryImplTest {
    private FindVideoByTitleCategory findVideoByTitleCategory;
    @Mock
    private VideoRepository videoRepository;
    private Category category;
    private Category category2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findVideoByTitleCategory = new FindVideoByTitleCategoryImpl(videoRepository);

        category = new Category("title", "description");
        category.addVideo(new Video("title0", "description0", "url0", this.category));
        category.addVideo(new Video("title1", "description1", "url1", this.category));

        category2 = new Category("title2", "description2");
    }

    @Test
    @DisplayName("Should return a list of videos by title category")
    void test1() {
        Mockito.when(videoRepository.findAllByCategoryTitle("title")).thenReturn(category.getVideos());
        List<Video> videos = findVideoByTitleCategory.getVideoByTitleCategory("title");
        Assertions.assertEquals(2, videos.size());
    }

    @Test
    @DisplayName("Should return empty list when there is no video in the category")
    void test2() {
        Mockito.when(videoRepository.findAllByCategoryTitle("title2")).thenReturn(category.getVideos());
        List<Video> videos = findVideoByTitleCategory.getVideoByTitleCategory("title2");
        Assertions.assertEquals(0, videos.size());
    }
}