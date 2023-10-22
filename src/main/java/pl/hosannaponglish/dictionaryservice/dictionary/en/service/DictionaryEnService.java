package pl.hosannaponglish.dictionaryservice.dictionary.en.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.en.repository.DictionaryEnRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryService;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@RequiredArgsConstructor
@Service
public class DictionaryEnService implements DictionaryService{

    private final DictionaryEnRepository repository;

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
    public Dictionary addNewDictionaryRecord(DictionaryDto dto){
        DictionaryEn newDictionary = new DictionaryEn();

        newDictionary.setExpression(dto.getExpression());
        newDictionary.setCategory(dto.getCategory());

        return repository.save(newDictionary);
    }

    @Override
    public boolean canHandle(LanguageCode code){
        return LanguageCode.EN.equals(code);
    }
}
