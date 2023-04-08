package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface FindVideoByTitleCategory {
    List<Video> getVideoByTitleCategory(String title);
    Page<Video> getVideoByTitleCategoryPage(String title, Pageable pageable);
}
