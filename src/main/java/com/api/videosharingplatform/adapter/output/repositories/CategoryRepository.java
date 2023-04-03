package com.api.videosharingplatform.adapter.output.repositories;

import com.api.videosharingplatform.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByTitle(String title);

}
