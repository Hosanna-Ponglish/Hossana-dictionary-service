package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.model.DictionaryEnPl;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

public interface DictionaryEnPlRepository extends JpaRepository<DictionaryEnPl, Long>{
}
