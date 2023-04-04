package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.domain.entities.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

class FindAllCategoriesImplTest {

    private FindAllCategories findAllCategories;
    @Mock
    private CategoryRepository categoryRepository;
    private List<Category> categories;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.findAllCategories = new FindAllCategoriesImpl(categoryRepository);

        categories = List.of(
                new Category("title", "colour"),
                new Category("title2", "colour2"));
    }

    @Test
    @DisplayName("Should return null when there is no category")
    void test1() {
        Mockito.when(categoryRepository.findAll()).thenReturn(null);
        List<Category> categories = findAllCategories.getAllCategory();
        Assertions.assertEquals(categories, null);
    }

    @Test
    @DisplayName("Should return a list of categories")
    void test2() {
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> list = findAllCategories.getAllCategory();
        Assertions.assertEquals(list, categories);
    }
}