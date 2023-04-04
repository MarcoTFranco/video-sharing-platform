package com.api.videosharingplatform.usecases.category;

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

class FindByIdCategoryImplTest {
    private FindByIdCategory findByIdCategory;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.findByIdCategory = new FindByIdCategoryImpl(categoryRepository);
    }

    @Test
    @DisplayName("Should return a category by id")
    void test1() {
        Mockito.when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(new Category("title", "description")));

        Category category = findByIdCategory.getCategoryById(1L);
        Assertions.assertNotNull(category);
    }

    @Test
    @DisplayName("Should return resourceNotFoundException when there is no category")
    void test2() {
        Mockito.when(categoryRepository.findById(1L))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> findByIdCategory.getCategoryById(1L));
    }

}