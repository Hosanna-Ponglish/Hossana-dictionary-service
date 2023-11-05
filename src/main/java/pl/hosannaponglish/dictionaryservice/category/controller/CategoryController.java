package pl.hosannaponglish.dictionaryservice.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.category.model.CategoryDto;
import pl.hosannaponglish.dictionaryservice.category.service.CategoryService;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@RestController
@RequestMapping("api/v1/category/")
@RequiredArgsConstructor
public class CategoryController{

    private final CategoryService service;

    @GetMapping()
    @ResponseBody
    public Page<Category> getAll(Pageable pageable){
        return service.getAll(pageable);
    }

    @GetMapping("{id}")
    @ResponseBody
    public Category getAll(@PathVariable Long id){
        return service.getOneById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable Long id){
        if(service.deleteById(id)){
            return ResponseEntity.ok()
                    .build();
        }

        return ResponseEntity.notFound()
                .build();
    }

    @PostMapping()
    public ResponseEntity<Category> createOne(@RequestBody @Valid CategoryDto dto){
        Category createdCategory = service.addNewCategoryRecord(dto);

        if(createdCategory != null){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdCategory);
        }

        return ResponseEntity.badRequest()
                .build();
    }
}
