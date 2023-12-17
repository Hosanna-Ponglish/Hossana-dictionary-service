package pl.hosannaponglish.dictionaryservice.translation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface TranslationService{

    Page<Translation> getAll(Pageable pageable);

    Translation getOneById(Long id);

    boolean canHandle(TranslationCode code);

    boolean deleteById(Long id);

    Translation addNewTranslationRecord(TranslationDto dto);
}
