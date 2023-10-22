package pl.hosannaponglish.dictionaryservice.dictionary.es.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.es.repository.DictionaryEsRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryService;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@RequiredArgsConstructor
@Service
public class DictionaryEsService implements DictionaryService{

    private final DictionaryEsRepository repository;

    @Override
    public Page<Dictionary> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }

    @Override
    public Dictionary getOneById(Long id){
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

    @Override
    public boolean canHandle(LanguageCode code){
        return LanguageCode.ES.equals(code);
    }
}
