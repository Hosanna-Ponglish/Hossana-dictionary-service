package pl.hosannaponglish.dictionaryservice.dictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LanguageCodeNotSupported extends RuntimeException{

    public LanguageCodeNotSupported(){
        super("Given language code is not supported");
    }
}
