package pl.hosannaponglish.dictionaryservice.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

import java.util.Optional;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

public interface DictionaryRepository extends JpaRepository<Dictionary, Long>{

    @Query(value = "select d from Dictionary d where d.translationEn like :data or d.translationPl like :data")
    Optional<Dictionary> simpleSearch(@Param("data") String data);
}
