package com.api.videosharingplatform.adapter.input.controller;

import com.api.videosharingplatform.adapter.input.request.VideoRequest;
import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.domain.entities.Video;
import com.api.videosharingplatform.usecases.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    @Autowired
    private InsertVideo insertVideo;
    @Autowired
    private FindAllVideo findAllVideo;
    @Autowired
    private FindByIdVideo findByIdVideo;
    @Autowired
    private UpdateVideo updateVideo;
    @Autowired
    private DeleteVideo deleteVideo;
    @Autowired
    private FindVideoByTitleCategory findVideoByTitleCategory;

    @PostMapping("/videos")
    public ResponseEntity<VideoResponse> createVideo(@Valid @RequestBody VideoRequest videoRequest) {
        Video video = insertVideo.createVideo(videoRequest);
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(videoResponse);
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<VideoResponse> getVideo(@PathVariable Long id) {
        Optional<Video> optionalVideo = findAllVideo.getVideo(id);
        Video video = optionalVideo.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.ok().body(videoResponse);
    }

    @GetMapping("/videos")
    public ResponseEntity<List<VideoResponse>> getAllVideo() {
        List <VideoResponse> videoResponse = findByIdVideo.getAllVideo().stream()
                .map(VideoResponse::new)
                .toList();
        return ResponseEntity.ok().body(videoResponse);
    }

    @PutMapping("/videos/{id}")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable Long id, @Valid @RequestBody VideoRequest videoRequest) {
        Video video = updateVideo.changeVideoFields(id, videoRequest);
        VideoResponse videoResponse = new VideoResponse(video);
        return ResponseEntity.ok().body(videoResponse);
    }

    @DeleteMapping("/videos/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        deleteVideo.deleteVideoById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/videos/")
    public ResponseEntity<List<VideoResponse>> getVideosByCategoryTitle(@RequestParam(value = "search") String title) {
        List <VideoResponse> videoResponse = findVideoByTitleCategory.getVideoByTitleCategory(title)
                .stream()
                .map(VideoResponse::new)
                .toList();
        return ResponseEntity.ok().body(videoResponse);
    }

}
