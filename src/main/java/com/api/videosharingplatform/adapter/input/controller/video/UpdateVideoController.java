package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.usecases.video.UpdateVideo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateVideoController {
    @Autowired
    private UpdateVideo updateVideo;

    @PutMapping("/videos/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable Long id, @Valid @RequestBody VideoRequest videoRequest) {
        Video video = updateVideo.changeVideoFields(id, videoRequest);
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.ok().body(videoResponse);
    }
}
