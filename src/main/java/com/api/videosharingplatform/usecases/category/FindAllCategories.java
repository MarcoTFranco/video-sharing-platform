package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.domain.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.channels.FileChannel;
import java.util.List;

public interface FindAllCategories {

    List<Category> getAllCategory();

    Page<Category> getAllCategoryPage(Pageable pageable);
}
