package pl.hosannaponglish.dictionaryservice.translation.code.enes.service;

import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.model.TranslationEnEs;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.repository.TranslationEnEsRepository;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationBaseService;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Service
public class TranslationEnEsService extends TranslationBaseService<TranslationEnEs>{

    private final TranslationEnEsRepository repository;

    public TranslationEnEsService(TranslationEnEsRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public boolean canHandle(TranslationCode code){
        return TranslationCode.ENES.equals(code);
    }

    @Override
    public Translation addNewTranslationRecord(TranslationDto dto){
        TranslationEnEs newTranslation = new TranslationEnEs();

        newTranslation.setExpressionSource((DictionaryEn) dto.getExpressionSource());
        newTranslation.setExpressionTarget((DictionaryEs) dto.getExpressionTarget());

        return repository.save(newTranslation);
    }

}
