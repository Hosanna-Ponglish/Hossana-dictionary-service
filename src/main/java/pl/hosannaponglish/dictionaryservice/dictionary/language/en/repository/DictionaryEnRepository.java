package pl.hosannaponglish.dictionaryservice.dictionary.language.en.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.repository.DictionaryRepository;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

public interface DictionaryEnRepository extends DictionaryRepository<DictionaryEn, Long>{

    @Query(value = "select en from DictionaryEn en")
    Page<Dictionary> getAll(Pageable pageable);
}
