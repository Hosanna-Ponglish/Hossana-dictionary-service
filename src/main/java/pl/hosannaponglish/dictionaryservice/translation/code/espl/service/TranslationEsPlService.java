package pl.hosannaponglish.dictionaryservice.translation.code.espl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.repository.TranslationEsPlRepository;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationBaseService;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Service
public class TranslationEsPlService extends TranslationBaseService<TranslationEsPl>{

    private final TranslationEsPlRepository repository;

    public TranslationEsPlService(TranslationEsPlRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<Translation> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }

    @Override
    public boolean canHandle(TranslationCode code){
        return TranslationCode.ESPL.equals(code);
    }

    @Override
    public Translation addNewTranslationRecord(TranslationDto dto){
        TranslationEsPl newTranslation = new TranslationEsPl();

        newTranslation.setExpressionSource((DictionaryEs) dto.getExpressionSource());
        newTranslation.setExpressionTarget((DictionaryPl) dto.getExpressionTarget());

        return repository.save(newTranslation);
    }

}
