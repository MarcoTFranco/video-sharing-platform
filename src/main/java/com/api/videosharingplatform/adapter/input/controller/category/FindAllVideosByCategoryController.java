package com.api.videosharingplatform.adapter.input.controller.category;

import com.api.videosharingplatform.adapter.output.response.VideoResponse;
import com.api.videosharingplatform.usecases.category.FindAllVideosByCategory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<VideoResponse>> getAllVideosByCategory(@PathVariable Long id) {
        List<VideoResponse> list = findAllVideosByCategory.getAllVideosByCategory(id).stream()
                .map(VideoResponse::new).toList();
        return ResponseEntity.ok().body(list);
    }


}
