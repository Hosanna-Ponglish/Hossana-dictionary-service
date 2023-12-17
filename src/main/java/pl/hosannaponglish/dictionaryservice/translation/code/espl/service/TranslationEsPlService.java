package pl.hosannaponglish.dictionaryservice.translation.code.espl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.repository.TranslationEsPlRepository;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationService;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Service
public class TranslationEsPlService implements TranslationService{

    private final TranslationEsPlRepository repository;

    public TranslationEsPlService(TranslationEsPlRepository repository){
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
        return TranslationCode.ESPL.equals(code);
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
        TranslationEsPl newTranslation = new TranslationEsPl();

        newTranslation.setExpressionSource((DictionaryEs) dto.getExpressionSource());
        newTranslation.setExpressionTarget((DictionaryPl) dto.getExpressionTarget());

        return repository.save(newTranslation);
    }

}
