package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.video.FindAllVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllVideoController {
    @Autowired
    private FindAllVideo findAllVideo;

    @GetMapping("/videos")
    public ResponseEntity<List<VideoResponse>> getAllVideo() {
        List<VideoResponse> videoResponse = findAllVideo.getAllVideo()
                .stream()
                .map(VideoResponse::new)
                .toList();
        return ResponseEntity.ok().body(videoResponse);
    }
}
