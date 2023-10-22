package pl.hosannaponglish.dictionaryservice.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;

import java.util.List;
import java.util.Optional;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Component
public class DictionaryServiceFactory{

    @Autowired
    private List<DictionaryService> services;

    public Optional<DictionaryService> getService(LanguageCode code){
        return services.stream()
                .filter(service -> service.canHandle(code))
                .findFirst();
    }
}
