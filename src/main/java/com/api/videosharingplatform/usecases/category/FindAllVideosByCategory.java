package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.domain.entities.Video;

import java.util.List;

public interface FindAllVideosByCategory {

    List<Video> getAllVideosByCategory(Long id);

}
