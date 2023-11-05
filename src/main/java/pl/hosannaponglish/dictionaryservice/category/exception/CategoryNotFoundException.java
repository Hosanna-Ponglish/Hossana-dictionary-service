package pl.hosannaponglish.dictionaryservice.category.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(Long id){
        super("Category record with id=" + id + " not found");
    }

}
