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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindVideoByTitleCategoryImplTest {
    private FindVideoByTitleCategory findVideoByTitleCategory;
    @Mock
    private CategoryRepository categoryRepository;
    private Category category;
    private Category category2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        findVideoByTitleCategory = new FindVideoByTitleCategoryImpl(categoryRepository);

        category = new Category("title", "description");
        category.addVideo(new Video("title0", "description0", "url0", this.category));
        category.addVideo(new Video("title1", "description1", "url1", this.category));

        category2 = new Category("title2", "description2");
    }

    @Test
    @DisplayName("Should return a list of videos by title category")
    void test1() {
        Mockito.when(categoryRepository.findByTitle("title")).thenReturn(Optional.of(category));
        List<Video> videos = findVideoByTitleCategory.getVideoByTitleCategory("title");
        Assertions.assertEquals(videos.size(), 2);
    }

    @Test
    @DisplayName("Should return empty list when there is no video in the category")
    void test2() {
        Mockito.when(categoryRepository.findByTitle("title2")).thenReturn(Optional.of(category2));
        List<Video> videos = findVideoByTitleCategory.getVideoByTitleCategory("title2");
        Assertions.assertEquals(videos.size(), 0);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when category is not found")
    void test3() {
        Mockito.when(categoryRepository.findByTitle("title3")).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> findVideoByTitleCategory.getVideoByTitleCategory("title3"));
    }
}