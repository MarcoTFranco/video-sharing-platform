package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.domain.entities.Category;

public interface UpdateCategory {

    Category changeCategoryFields(Long id, CategoryRequest categoryRequest);

}
