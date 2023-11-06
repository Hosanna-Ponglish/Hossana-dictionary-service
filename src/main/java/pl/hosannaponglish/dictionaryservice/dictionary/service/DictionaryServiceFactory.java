package pl.hosannaponglish.dictionaryservice.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.LanguageCodeNotSupported;

import java.util.List;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Component
@RequiredArgsConstructor
public class DictionaryServiceFactory{

    private final List<DictionaryService> services;

    public DictionaryService getService(LanguageCode code){
        return services.stream()
                .filter(service -> service.canHandle(code))
                .findFirst()
                .orElseThrow(LanguageCodeNotSupported::new);
    }
}
