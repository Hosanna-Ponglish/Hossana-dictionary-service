package pl.hosannaponglish.dictionaryservice.translation.code.enpl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.model.TranslationEnPl;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.repository.TranslationRepository;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface TranslationEnPlRepository extends TranslationRepository<TranslationEnPl, Long>{

    @Query(value = "select enpl from TranslationEnPl enpl")
    Page<Translation> getAll(Pageable pageable);
}
