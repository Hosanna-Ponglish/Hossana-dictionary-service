package pl.hosannaponglish.dictionaryservice.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.category.exception.CategoryNotFoundException;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.category.repository.CategoryRepository;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@Service
@RequiredArgsConstructor
public class CategoryService{

    private final CategoryRepository repository;

    public Page<Category> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Category getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
