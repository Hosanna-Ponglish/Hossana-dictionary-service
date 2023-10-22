package pl.hosannaponglish.dictionaryservice.dictionary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

public interface DictionaryService{

    Page<Dictionary> getAll(Pageable pageable);

    Dictionary getOneById(Long id);

    boolean deleteById(Long id);

    boolean canHandle(LanguageCode code);
}
