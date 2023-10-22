package pl.hosannaponglish.dictionaryservice.dictionary.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

public abstract class DictionaryBaseService<T extends Dictionary> implements DictionaryService{

    private final JpaRepository<T, Long> repository;

    public DictionaryBaseService(JpaRepository<T, Long> repository){
        this.repository = repository;
    }

    @Override
    public T getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DictionaryNotFoundException(id));
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
