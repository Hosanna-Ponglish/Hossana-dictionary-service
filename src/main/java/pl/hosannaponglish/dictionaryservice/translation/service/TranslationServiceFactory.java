package pl.hosannaponglish.dictionaryservice.translation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationCodeNotSupported;

import java.util.List;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Component
@RequiredArgsConstructor
public class TranslationServiceFactory{

    private final List<TranslationService> services;

    public TranslationService getService(TranslationCode code){
        return services.stream()
                .filter(service -> service.canHandle(code))
                .findFirst()
                .orElseThrow(TranslationCodeNotSupported::new);
    }
}
