package pl.hosannaponglish.dictionaryservice.translation.code.enpl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.model.TranslationEnPl;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.repository.TranslationEnPlRepository;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationBaseService;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Service
public class TranslationEnPlService extends TranslationBaseService<TranslationEnPl>{

    private final TranslationEnPlRepository repository;

    public TranslationEnPlService(TranslationEnPlRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<Translation> getAll(Pageable pageable){
        return repository.getAll(pageable);
    }

    @Override
    public boolean canHandle(TranslationCode code){
        return TranslationCode.ENPL.equals(code);
    }

    @Override
    public Translation addNewTranslationRecord(TranslationDto dto){
        TranslationEnPl newTranslation = new TranslationEnPl();

        newTranslation.setExpressionSource((DictionaryEn) dto.getExpressionSource());
        newTranslation.setExpressionTarget((DictionaryPl) dto.getExpressionTarget());

        return repository.save(newTranslation);
    }
}
