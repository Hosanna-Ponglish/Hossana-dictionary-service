package pl.hosannaponglish.dictionaryservice.translation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public abstract class TranslationBaseService<T extends Translation> implements TranslationService{

    private final JpaRepository<T, Long> repository;

    protected TranslationBaseService(JpaRepository<T, Long> repository){
        this.repository = repository;
    }

    @Override
    public T getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TranslationNotFoundException(id));
    }

    @Override
    public boolean deleteById(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
