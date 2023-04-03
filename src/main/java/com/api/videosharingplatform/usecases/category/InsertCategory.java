package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.domain.entities.Category;

public interface InsertCategory {

    Category createCategory(CategoryRequest categoryRequest);

}
