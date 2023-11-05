package pl.hosannaponglish.dictionaryservice.category.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.category.exception.CategoryNotFoundException;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.category.model.CategoryDto;
import pl.hosannaponglish.dictionaryservice.category.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest{

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @BeforeEach
    public void setUp(){
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void testGetAllCategories(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Category> categoryPage = new PageImpl<>(List.of(new Category(), new Category()));
        when(categoryRepository.findAll(pageable)).thenReturn(categoryPage);

        Page<Category> result = categoryService.getAll(pageable);

        assertEquals(2, result.getTotalElements());
        verify(categoryRepository, times(1)).findAll(pageable);
    }

    @Test
    public void testGetCategoryByIdExists(){
        Long categoryId = 1L;
        Category category = new Category();
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        Category result = categoryService.getOneById(categoryId);

        assertEquals(category, result);
    }

    @Test
    public void testGetCategoryByIdNotFound(){
        Long categoryId = 1L;
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> categoryService.getOneById(categoryId));
    }

    @Test
    public void testAddNewCategoryRecord(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setSymbol("TestCategory");

        when(categoryRepository.save(any(Category.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Category result = categoryService.addNewCategoryRecord(categoryDto);

        assertNotNull(result);
        assertEquals("TestCategory", result.getSymbol());
    }

    @Test
    public void testDeleteCategoryExists(){
        Long categoryId = 1L;
        when(categoryRepository.existsById(categoryId)).thenReturn(true);

        boolean deleted = categoryService.deleteById(categoryId);

        assertTrue(deleted);
        verify(categoryRepository, times(1)).deleteById(categoryId);
    }

    @Test
    public void testDeleteCategoryNotExists(){
        Long categoryId = 1L;
        when(categoryRepository.existsById(categoryId)).thenReturn(false);

        boolean deleted = categoryService.deleteById(categoryId);

        assertFalse(deleted);
        verify(categoryRepository, never()).deleteById(categoryId);
    }
}