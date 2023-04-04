package com.api.videosharingplatform.usecases.category;

import com.api.videosharingplatform.adapter.output.repositories.CategoryRepository;
import com.api.videosharingplatform.service.exceptions.DataBaseException;
import com.api.videosharingplatform.service.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteCategoryByIdImplTest {
    private DeleteCategoryByIdImpl deleteCategoryByIdImpl;
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.deleteCategoryByIdImpl = new DeleteCategoryByIdImpl(categoryRepository);
    }

    @Test
    @DisplayName("Should delete a category")
    void test1() {
        deleteCategoryByIdImpl.deleteCategoryById(1L);
        Mockito.verify(categoryRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw ResourceNotFoundException when category is not found")
    void test2() {
        Mockito.doThrow(new EmptyResultDataAccessException(1)).when(categoryRepository).deleteById(1L);
        assertThrows(ResourceNotFoundException.class, () -> {
            deleteCategoryByIdImpl.deleteCategoryById(1L);
        });
    }

    @Test
    @DisplayName("Should throw DataBaseException when has error in database")
    void test3() {
        Mockito.doThrow(new DataIntegrityViolationException(" ")).when(categoryRepository).deleteById(1L);
        assertThrows(DataBaseException.class, () -> {
            deleteCategoryByIdImpl.deleteCategoryById(1L);
        });
    }
}