package com.api.videosharingplatform.adapter.output.repositories;

import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.domain.entities.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
