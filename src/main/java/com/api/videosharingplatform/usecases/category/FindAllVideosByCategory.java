package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.channels.FileChannel;
import java.util.List;

public interface FindAllVideosByCategory {

    List<Video> getAllVideosByCategory(Long id);

    Page<Video> getAllVideosByCategoryPage(Long id, Pageable pageable);
}
