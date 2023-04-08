package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.category.FindAllVideosByCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllVideosByCategoryController {

    @Autowired
    private FindAllVideosByCategory findAllVideosByCategory;


    @GetMapping("/categories/{id}/videos")
    public ResponseEntity<Page<VideoResponse>> getAllVideosByCategory(@PathVariable Long id,
                                                                      @PageableDefault(size = 5) Pageable pageable) {
        Page<VideoResponse> list = findAllVideosByCategory.getAllVideosByCategoryPage(id, pageable)
                .map(VideoResponse::new);
        return ResponseEntity.ok(list);
    }


}
