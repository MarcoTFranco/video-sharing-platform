package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.video.FindVideoByTitleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FindVideoByTitleCategoryController {

    @Autowired
    private FindVideoByTitleCategory findVideoByTitleCategory;

    @GetMapping("/videos/")
    public ResponseEntity<List<VideoResponse>> getVideosByCategoryTitle(@RequestParam(value = "search") String title) {
        List<VideoResponse> videoResponse = findVideoByTitleCategory.getVideoByTitleCategory(title)
                .stream()
                .map(VideoResponse::new)
                .toList();
        return ResponseEntity.ok().body(videoResponse);
    }


}
