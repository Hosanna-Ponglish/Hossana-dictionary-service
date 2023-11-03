package pl.hosannaponglish.dictionaryservice.dictionary.en.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

public interface DictionaryEnRepository extends JpaRepository<DictionaryEn, Long>{

    @Query(value = "select en from DictionaryEn en")
    Page<Dictionary> getAll(Pageable pageable);
}
