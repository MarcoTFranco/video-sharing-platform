package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.usecases.video.InsertVideo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateVideoController {
    @Autowired
    private InsertVideo insertVideo;

    @PostMapping("/videos")
    public ResponseEntity<VideoResponse> createVideo(@Valid @RequestBody VideoRequest videoRequest) {
        Video video = insertVideo.createVideo(videoRequest);
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(videoResponse);
    }

}
