package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class UpdateCategoryImplTest {

    private UpdateCategoryImpl updateCategory;
    private Category category;
    @Mock
    private CategoryRepository categoryRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.updateCategory = new UpdateCategoryImpl(categoryRepository);

        category = new Category("title", "colour");
    }

    @Test
    @DisplayName("Should change category fields")
    void test1() {
        Mockito.when(categoryRepository.findById(2L)).thenReturn(Optional.of(category));
        Category categoryUpdate = updateCategory
                .changeCategoryFields(2L, new CategoryRequest("title1", "colour1"));
        Assertions.assertEquals(categoryUpdate.getTitle(), "title1");
        Assertions.assertEquals(categoryUpdate.getColour(), "colour1");
        Mockito.verify(categoryRepository).save(category);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when category not found")
    void test2() {
        Mockito.when(categoryRepository.findById(2L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            updateCategory.changeCategoryFields(2L, new CategoryRequest("title1", "colour1"));
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when id is null")
    void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            updateCategory.changeCategoryFields(null, new CategoryRequest("title1", "colour1"));
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when id is 1")
    void test4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            updateCategory.changeCategoryFields(1L, new CategoryRequest("title1", "colour1"));
        });
    }
}