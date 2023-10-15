package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DictionaryEnPlNotFoundException extends RuntimeException{

    public DictionaryEnPlNotFoundException(Long id){
        super("DictionaryEnPl record with id=" + id + " not found");
    }
}
