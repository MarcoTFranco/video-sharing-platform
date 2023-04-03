package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.domain.entities.Category;

public interface FindByIdCategory {

    Category getCategoryById(Long id);
}
