package pl.hosannaponglish.dictionaryservice.dictionary.language.pl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.repository.DictionaryRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

public interface DictionaryPlRepository extends DictionaryRepository<DictionaryPl, Long>{

    @Query(value = "select pl from DictionaryPl pl")
    Page<Dictionary> getAll(Pageable pageable);
}
