package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.model.DictionaryEnPl;

import java.util.Optional;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

public interface DictionaryEnPlRepository extends JpaRepository<DictionaryEnPl, Long>{

    @Query(value = "select d from DictionaryEnPl d where d.translation_en like :data or d.translation_pl like :data")
    Optional<DictionaryEnPl> simpleSearch(@Param("data") String data);
}
