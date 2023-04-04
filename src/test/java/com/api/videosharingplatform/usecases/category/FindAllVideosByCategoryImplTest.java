package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

class FindAllVideosByCategoryImplTest {

    private FindAllVideosByCategory findAllVideosByCategory;
    @Mock
    private CategoryRepository categoryRepository;
    private Category category;
    private Category category2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.findAllVideosByCategory = new FindAllVideosByCategoryImpl(categoryRepository);

        category = new Category("title", "description");
        category.addVideo(new Video("title0", "description0", "url0", this.category));
        category.addVideo(new Video("title1", "description1", "url1", this.category));

        category2 = new Category("title2", "description2");
    }

    @Test
    @DisplayName("Should return all videos by category")
    void test1() {
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category));
        List<Video> videos = findAllVideosByCategory.getAllVideosByCategory(1L);
        Assertions.assertEquals(videos.size(), 2);
    }

    @Test
    @DisplayName("Should return empty list when there is no video in the category")
    void test2() {
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category2));
        List<Video> videos = findAllVideosByCategory.getAllVideosByCategory(1L);
        Assertions.assertEquals(videos.size(), 0);
    }
}