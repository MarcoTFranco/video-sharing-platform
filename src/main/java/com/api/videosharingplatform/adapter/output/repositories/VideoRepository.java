package com.api.videosharingplatform.adapter.output.repositories;

import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByCategoryTitle(String title);
    Page<Video> findAllByCategoryTitle(String title, Pageable pageable);
}
