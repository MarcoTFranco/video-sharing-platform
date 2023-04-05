package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.input.request.CategoryRequest;
import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class InsertCategoryImplTest {

    private InsertCategory insertCategoryImpl;
    @Mock
    private CategoryRepository categoryRepository;
    @Captor
    private ArgumentCaptor<Category> captor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.insertCategoryImpl = new InsertCategoryImpl(categoryRepository);
    }

    @Test
    @DisplayName("Should create a category")
    void test1() {
        Category category = insertCategoryImpl.createCategory(new CategoryRequest("Category Test",
                "Category Test Description"));

        Mockito.verify(categoryRepository).save(captor.capture());
        Assertions.assertEquals(category, captor.getValue());
        Assertions.assertNotNull(category);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when categoryRequest is null")
    void test2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            insertCategoryImpl.createCategory(null);
        });
    }
}