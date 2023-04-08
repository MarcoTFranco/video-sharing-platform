package com.api.videosharingplatform.adapter.input.controller.video;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.video.FindVideoByTitleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<VideoResponse>> getVideosByCategoryTitle(@RequestParam(value = "search") String title,
                                                                        @PageableDefault(size = 5) Pageable pageable) {
        Page<VideoResponse> videoResponse = findVideoByTitleCategory.getVideoByTitleCategoryPage(title, pageable)
                .map(VideoResponse::new);
        return ResponseEntity.ok(videoResponse);
    }


}
