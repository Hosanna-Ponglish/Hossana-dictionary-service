package pl.hosannaponglish.dictionaryservice.dictionary.language.en.service;

import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.repository.DictionaryEnRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryBaseService;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@Service
public class DictionaryEnService extends DictionaryBaseService<DictionaryEn>{

    private final DictionaryEnRepository repository;

    public DictionaryEnService(DictionaryEnRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Dictionary addNewDictionaryRecord(DictionaryDto dto){
        DictionaryEn newDictionary = new DictionaryEn();

        newDictionary.setExpression(dto.getExpression());
        newDictionary.setCategories(dto.getCategories());

        return repository.save(newDictionary);
    }

    @Override
    public boolean canHandle(LanguageCode code){
        return LanguageCode.EN.equals(code);
    }
}
