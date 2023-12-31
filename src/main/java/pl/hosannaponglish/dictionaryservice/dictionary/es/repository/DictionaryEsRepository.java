package pl.hosannaponglish.dictionaryservice.dictionary.es.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */
public interface DictionaryEsRepository extends JpaRepository<DictionaryEs, Long>{
    @Query(value = "select es from DictionaryEs es")
    Page<Dictionary> getAll(Pageable pageable);
}
