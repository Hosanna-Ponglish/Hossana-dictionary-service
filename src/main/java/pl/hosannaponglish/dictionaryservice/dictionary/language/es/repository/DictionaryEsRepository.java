package pl.hosannaponglish.dictionaryservice.dictionary.language.es.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.repository.DictionaryRepository;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */
public interface DictionaryEsRepository extends DictionaryRepository<DictionaryEs, Long>{
    @Query(value = "select es from DictionaryEs es")
    Page<Dictionary> getAll(Pageable pageable);
}
