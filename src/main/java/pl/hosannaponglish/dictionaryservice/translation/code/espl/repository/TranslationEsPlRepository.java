package pl.hosannaponglish.dictionaryservice.translation.code.espl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.repository.TranslationRepository;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface TranslationEsPlRepository extends TranslationRepository<TranslationEsPl, Long>{

    @Query(value = "select espl from TranslationEsPl espl")
    Page<Translation> getAll(Pageable pageable);
}
