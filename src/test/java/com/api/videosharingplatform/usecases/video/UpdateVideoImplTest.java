package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UpdateVideoImplTest {

    private UpdateVideo updateVideo;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Captor
    private ArgumentCaptor<Video> videoCaptor;
    private Category category;
    private Video video;
    VideoRequest videoRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateVideo = new UpdateVideoImpl(videoRepository, categoryRepository);
        category= new Category("category", "description");
        video = new Video("title", "description", "url", category);
        videoRequest = new VideoRequest("title1", "description1", "url1");
    }

    @Test
    @DisplayName("Should return a video")
    void test1() {
        videoRequest.setCategoryId(1L);
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category));
        Mockito.when(videoRepository.findById(1L)).thenReturn(Optional.ofNullable(video));

        Video video = updateVideo.changeVideoFields(1L, videoRequest);

        Mockito.verify(videoRepository).save(videoCaptor.capture());
        Assertions.assertNotNull(video);
        Assertions.assertEquals(videoCaptor.getValue().getTitle(), videoRequest.getTitle());
        Assertions.assertEquals(videoCaptor.getValue().getDescription(), videoRequest.getDescription());
        Assertions.assertEquals(videoCaptor.getValue().getUrl(), videoRequest.getUrl());
    }

    @Test
    @DisplayName("Should throw an ResponseStatusException when video not found")
    void test2() {
        videoRequest.setCategoryId(1L);
        Mockito.when(videoRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResponseStatusException.class, () -> updateVideo.changeVideoFields(1L, videoRequest));
    }

    @Test
    @DisplayName("Should throw ResponseStatusException when id of the category in VideoRequest is not found")
    void test3() {
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            updateVideo.changeVideoFields(1L, videoRequest);
        });
    }

    @Test
    @DisplayName("Should throw ResponseStatusException when id of the video is null")
    void test4() {
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            updateVideo.changeVideoFields(null, videoRequest);
        });
    }

}