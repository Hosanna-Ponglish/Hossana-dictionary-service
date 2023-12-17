package pl.hosannaponglish.dictionaryservice.translation.code.enes.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.model.TranslationEnEs;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.repository.TranslationEnEsRepository;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationService;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Service
public class TranslationEnEsService implements TranslationService{

    private final TranslationEnEsRepository repository;

    public TranslationEnEsService(TranslationEnEsRepository repository){
        this.repository = repository;
    }

    @Override
    public Page<Translation> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }

    @Override
    public Translation getOneById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TranslationNotFoundException(id));
    }

    @Override
    public boolean canHandle(TranslationCode code){
        return TranslationCode.ENES.equals(code);
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
    public Translation addNewTranslationRecord(TranslationDto dto){
        TranslationEnEs newTranslation = new TranslationEnEs();

        newTranslation.setExpressionSource((DictionaryEn) dto.getExpressionSource());
        newTranslation.setExpressionTarget((DictionaryEs) dto.getExpressionTarget());

        return repository.save(newTranslation);
    }

}
