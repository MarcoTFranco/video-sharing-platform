package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.usecases.video.FindVideoById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindVideoByIdController {

    @Autowired
    private FindVideoById findVideoById;

    @GetMapping("/videos/{id}")
    public ResponseEntity<VideoResponse> getVideo(@PathVariable Long id) {
        Video video = findVideoById.getVideo(id);
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.ok().body(videoResponse);
    }

}
