package pl.hosannaponglish.dictionaryservice.dictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DictionaryNotFoundException extends RuntimeException{

    public DictionaryNotFoundException(Long id){
        super("Dictionary record with id=" + id + " not found");
    }
}
