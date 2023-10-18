package pl.hosannaponglish.dictionaryservice.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.repository.DictionaryRepository;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RequiredArgsConstructor
@Service
public class DictionaryService{

    private final DictionaryRepository repository;

    public Page<Dictionary> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Dictionary getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DictionaryNotFoundException(id));
    }

    public Dictionary simpleFind(String data){
        return repository.simpleSearch("%" + data + "%")
                .orElse(null);
    }
}
