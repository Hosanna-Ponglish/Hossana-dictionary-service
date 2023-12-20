package pl.hosannaponglish.dictionaryservice.translation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;

/**
 * @author Bartosz Średziński
 * created on 20.12.2023
 */

@NoRepositoryBean
public interface TranslationRepository<T extends Translation, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<Translation>{

    Page<Translation> getAll(Pageable pageable);
}
