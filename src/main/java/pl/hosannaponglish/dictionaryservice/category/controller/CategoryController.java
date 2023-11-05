package pl.hosannaponglish.dictionaryservice.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
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
}
