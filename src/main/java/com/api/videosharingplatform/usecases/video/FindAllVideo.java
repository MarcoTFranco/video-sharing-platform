package com.api.videosharingplatform.usecases.video;

import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.channels.FileChannel;
import java.util.List;

public interface FindAllVideo {

    List<Video> getAllVideo();

    Page<Video> getAllVideoPage(Pageable pageable);
}
