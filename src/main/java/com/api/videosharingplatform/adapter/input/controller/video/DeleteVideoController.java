package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.usecases.video.DeleteVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteVideoController {

    @Autowired
    private DeleteVideo deleteVideo;

    @DeleteMapping("/videos/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        deleteVideo.deleteVideoById(id);
        return ResponseEntity.noContent().build();
    }
}
