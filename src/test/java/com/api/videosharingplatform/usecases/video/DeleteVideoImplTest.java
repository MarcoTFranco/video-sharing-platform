package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
import com.api.videosharingplatform.service.exceptions.DataBaseException;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

class DeleteVideoImplTest {

    private DeleteVideo deleteVideo;

    @Mock
    private VideoRepository videoRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteVideo = new DeleteVideoImpl(videoRepository);
    }

    @Test
    @DisplayName("Should delete a video")
    void deleteVideoById() {
        deleteVideo.deleteVideoById(1L);
        Mockito.verify(videoRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when video is not found")
    void test2() {
        Mockito.doThrow(new EmptyResultDataAccessException(1)).when(videoRepository).deleteById(1L);
        assertThrows(ResourceNotFoundException.class, () -> {
            deleteVideo.deleteVideoById(1L);
        });
    }

    @Test
    @DisplayName("Should throw DataBaseException when has error in database")
    void test3() {
        Mockito.doThrow(new DataIntegrityViolationException(" ")).when(videoRepository).deleteById(1L);
        assertThrows(DataBaseException.class, () -> {
            deleteVideo.deleteVideoById(1L);
        });
    }
}