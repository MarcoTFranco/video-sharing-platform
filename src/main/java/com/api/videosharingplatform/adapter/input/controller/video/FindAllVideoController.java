package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.video.FindAllVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllVideoController {
    @Autowired
    private FindAllVideo findAllVideo;

    @GetMapping("/videos")
    public ResponseEntity<Page<VideoResponse>> getAllVideo(@PageableDefault(size = 5) Pageable pageable) {
        Page<VideoResponse> videoResponse = findAllVideo.getAllVideoPage(pageable).map(VideoResponse::new);
        return ResponseEntity.ok(videoResponse);
    }
}
