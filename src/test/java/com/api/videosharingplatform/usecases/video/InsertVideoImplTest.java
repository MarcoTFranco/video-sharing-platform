package com.api.videosharingplatform.usecases.video;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InsertVideoImplTest {

    private InsertVideo insertVideo;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Captor
    private ArgumentCaptor<Video> captor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        insertVideo = new InsertVideoImpl(videoRepository, categoryRepository);
    }

    @Test
    @DisplayName("Should create a video")
    void test1() {
        Mockito.when(categoryRepository.findById(3L))
                .thenReturn(Optional.of(new Category("title", "description")));
        VideoRequest videoRequest = new VideoRequest("title", "description", "url");
        videoRequest.setCategoryId(3L);
        Video video = insertVideo.createVideo(videoRequest);

        Assertions.assertNotNull(video);
        Mockito.verify(videoRepository).save(captor.capture());
        Assertions.assertEquals(video, captor.getValue());
    }

    @Test
    @DisplayName("Should create a video with default category")
    void test2() {
        Mockito.when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(new Category("title", "description")));
        VideoRequest videoRequest = new VideoRequest("title", "description", "url");
        Video video = insertVideo.createVideo(videoRequest);

        Assertions.assertNotNull(video);
        Mockito.verify(videoRepository).save(captor.capture());
        Assertions.assertEquals(video, captor.getValue());
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when there is no category")
    void test3() {
        Mockito.when(categoryRepository.findById(1L))
                .thenReturn(Optional.empty());
        VideoRequest videoRequest = new VideoRequest("title", "description", "url");
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            insertVideo.createVideo(videoRequest);
        });
    }
}