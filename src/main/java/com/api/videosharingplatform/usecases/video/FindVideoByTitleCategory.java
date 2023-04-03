package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.domain.entities.Video;

import java.util.List;

public interface FindVideoByTitleCategory {

    List<Video> getVideoByTitleCategory(String title);
}
