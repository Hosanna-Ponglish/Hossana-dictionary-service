package pl.hosannaponglish.dictionaryservice.translation.code.espl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface TranslationEsPlRepository extends JpaRepository<TranslationEsPl, Long>{
    @Query(value = "select espl from TranslationEsPl espl")
    Page<Translation> getAll(Pageable pageable);
}
