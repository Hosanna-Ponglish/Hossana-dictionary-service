package pl.hosannaponglish.dictionaryservice.translation.code.enes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.model.TranslationEnEs;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.repository.TranslationRepository;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface TranslationEnEsRepository extends TranslationRepository<TranslationEnEs, Long>{

    @Query(value = "select enes from TranslationEnEs enes")
    Page<Translation> getAll(Pageable pageable);
}
