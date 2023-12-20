package pl.hosannaponglish.dictionaryservice.translation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TranslationCodeNotSupported extends RuntimeException{

    public TranslationCodeNotSupported(){
        super("Given translation code is not supported");
    }
}
