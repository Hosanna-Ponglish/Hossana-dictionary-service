package pl.hosannaponglish.dictionaryservice.dictionary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 21.12.2023
 */

@NoRepositoryBean
public interface DictionaryRepository<T extends Dictionary, ID> extends JpaRepository<T, ID>{

    Page<Dictionary> getAll(Pageable pageable);
}
