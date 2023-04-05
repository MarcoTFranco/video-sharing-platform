package com.api.videosharingplatform.usecases.video;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FindVideoByIdImplTest {

    private FindVideoById  findVideoById;
    @Mock
    private VideoRepository videoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        findVideoById = new FindVideoByIdImpl(videoRepository);
    }

    @Test
    @DisplayName("Should return a video")
    void test1() {
        Mockito.when(videoRepository.findById(1L)).thenReturn(Optional.of(
                new Video("title", "description", "url",
                        new Category("category", "description"))));

        Video video = findVideoById.getVideo(1L);

        Mockito.verify(videoRepository).findById(1L);
        Assertions.assertNotNull(video);
    }

    @Test
    @DisplayName("Should throw an ResourceNotFoundException when video is not found")
    void test2() {
        Mockito.when(videoRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> findVideoById.getVideo(1L));
    }

    @Test
    @DisplayName("Should throw an exception when id is null")
    void test3() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> findVideoById.getVideo(null));
    }
}