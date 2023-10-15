package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.exception.DictionaryEnPlNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.model.DictionaryEnPl;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.repository.DictionaryEnPlRepository;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RequiredArgsConstructor
@Service
public class DictionaryEnPlService{

    private final DictionaryEnPlRepository repository;

    public Page<DictionaryEnPl> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public DictionaryEnPl getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new DictionaryEnPlNotFoundException(id));
    }

    public DictionaryEnPl simpleFind(String data){
        return repository.simpleSearch("%" + data + "%")
                .orElse(null);
    }
}
