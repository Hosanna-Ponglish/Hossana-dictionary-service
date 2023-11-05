package pl.hosannaponglish.dictionaryservice.category.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.hosannaponglish.dictionaryservice.category.exception.CategoryNotFoundException;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.category.model.CategoryDto;
import pl.hosannaponglish.dictionaryservice.category.service.CategoryService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest{

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Test
    void testGetAllCategories(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Category> categoryPage = new PageImpl<>(List.of(new Category(), new Category()));
        when(categoryService.getAll(pageable)).thenReturn(categoryPage);

        Page<Category> result = categoryController.getAll(pageable);

        assertThat(result).isNotNull();
        assertThat(result.getTotalElements()).isEqualTo(2);
    }

    @Test
    void testGetCategoryByIdExists(){
        Long categoryId = 1L;
        Category category = new Category();
        when(categoryService.getOneById(categoryId)).thenReturn(category);

        Category result = categoryController.getAll(categoryId);

        assertThat(result).isNotNull().isEqualTo(category);
    }

    @Test
    void testGetCategoryByIdNotFound(){
        Long categoryId = 1L;
        when(categoryService.getOneById(categoryId)).thenThrow(new CategoryNotFoundException(categoryId));

        assertThatThrownBy(() -> categoryController.getAll(categoryId)).isInstanceOf(CategoryNotFoundException.class)
                .hasMessage("Category record with id=" + categoryId + " not found");
    }

    @Test
    void testDeleteCategoryExists(){
        Long categoryId = 1L;
        when(categoryService.deleteById(categoryId)).thenReturn(true);

        ResponseEntity<Long> responseEntity = categoryController.deleteOne(categoryId);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testDeleteCategoryNotExists(){
        Long categoryId = 1L;
        when(categoryService.deleteById(categoryId)).thenReturn(false);

        ResponseEntity<Long> responseEntity = categoryController.deleteOne(categoryId);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreateCategory(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setSymbol("TestCategory");
        Category createdCategory = new Category();
        createdCategory.setId(1L);
        createdCategory.setSymbol("TestCategory");

        when(categoryService.addNewCategoryRecord(categoryDto)).thenReturn(createdCategory);

        ResponseEntity<Category> responseEntity = categoryController.createOne(categoryDto);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isEqualTo(createdCategory);
    }

    @Test
    void testCreateCategoryBadRequest(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setSymbol(null);
        when(categoryService.addNewCategoryRecord(categoryDto)).thenReturn(null);

        ResponseEntity<Category> responseEntity = categoryController.createOne(categoryDto);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}