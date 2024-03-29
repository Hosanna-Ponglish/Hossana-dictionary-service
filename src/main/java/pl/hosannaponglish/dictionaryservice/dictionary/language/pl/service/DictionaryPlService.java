package pl.hosannaponglish.dictionaryservice.dictionary.language.pl.service;

import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.repository.DictionaryPlRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryBaseService;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Service
public class DictionaryPlService extends DictionaryBaseService<DictionaryPl>{

    private final DictionaryPlRepository repository;

    public DictionaryPlService(DictionaryPlRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Dictionary addNewDictionaryRecord(DictionaryDto dto){
        DictionaryPl newDictionary = new DictionaryPl();

        newDictionary.setExpression(dto.getExpression());
        newDictionary.setCategories(dto.getCategories());

        return repository.save(newDictionary);
    }

    @Override
    public boolean canHandle(LanguageCode code){
        return LanguageCode.PL.equals(code);
    }
}
