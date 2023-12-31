package pl.hosannaponglish.dictionaryservice.dictionary.pl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.model.DictionaryPl;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

public interface DictionaryPlRepository extends JpaRepository<DictionaryPl, Long>{

    @Query(value = "select pl from DictionaryPl pl")
    Page<Dictionary> getAll(Pageable pageable);
}
