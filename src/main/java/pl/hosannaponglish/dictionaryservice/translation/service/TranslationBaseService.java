package pl.hosannaponglish.dictionaryservice.translation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.repository.TranslationRepository;
import pl.hosannaponglish.dictionaryservice.translation.specification.TranslationSpecification;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public abstract class TranslationBaseService<T extends Translation> implements TranslationService{

    private final TranslationRepository<T, Long> repository;

    protected TranslationBaseService(TranslationRepository<T, Long> repository){
        this.repository = repository;
    }

    @Override
    public Page<Translation> getAll(Pageable pageable){
        return repository.getAll(pageable);
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

    @Override
    public Page<Translation> search(String expression, Pageable pageable){
        return repository.findAll(TranslationSpecification.hasExpressionSourceOrExpressionTargetLike(expression), pageable);
    }
}
