package pl.hosannaponglish.dictionaryservice.dictionary.es.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.es.repository.DictionaryEsRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryBaseService;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@Service
public class DictionaryEsService extends DictionaryBaseService<DictionaryEs>{

    private final DictionaryEsRepository repository;

    public DictionaryEsService(DictionaryEsRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<Dictionary> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }

    @Override
    public Dictionary addNewDictionaryRecord(DictionaryDto dto){
        DictionaryEs newDictionary = new DictionaryEs();

        newDictionary.setExpression(dto.getExpression());
        newDictionary.setCategories(dto.getCategories());

        return repository.save(newDictionary);
    }

    @Override
    public boolean canHandle(LanguageCode code){
        return LanguageCode.ES.equals(code);
    }
}
