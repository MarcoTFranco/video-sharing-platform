package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.adapter.output.repositories.VideoRepository;
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

import static org.junit.jupiter.api.Assertions.*;

class FindAllVideoImplTest {

    private FindAllVideo findAllVideo;
    @Mock
    private VideoRepository videoRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.findAllVideo = new FindAllVideoImpl(videoRepository);
    }

    @Test
    @DisplayName("Should return a list of videos")
    void test1() {
        Mockito.when(videoRepository.findAll()).thenReturn(List.of(
                new Video("title0", "description0", "url0",
                        new Category("title0", "description0")),
                new Video("title1", "description1", "url1",
                        new Category("title0", "description0"))
        ));
        List<Video> videos = findAllVideo.getAllVideo();
        Assertions.assertEquals(videos.size(), 2);
    }

    @Test
    @DisplayName("Should return a empty list of videos")
    void test2() {
        Mockito.when(videoRepository.findAll()).thenReturn(List.of());
        List<Video> videos = findAllVideo.getAllVideo();

        Assertions.assertEquals(videos.size(), 0);
        Assertions.assertTrue(videos.isEmpty());
    }
}