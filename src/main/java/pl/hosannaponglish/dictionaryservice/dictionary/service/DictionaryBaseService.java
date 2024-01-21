package pl.hosannaponglish.dictionaryservice.dictionary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.repository.DictionaryRepository;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

public abstract class DictionaryBaseService<T extends Dictionary> implements DictionaryService{

    private final DictionaryRepository<T, Long> repository;

    protected DictionaryBaseService(DictionaryRepository<T, Long> repository){
        this.repository = repository;
    }

    @Override
    public Page<Dictionary> getAll(Pageable pageable){
        return repository.getAll(pageable);
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
