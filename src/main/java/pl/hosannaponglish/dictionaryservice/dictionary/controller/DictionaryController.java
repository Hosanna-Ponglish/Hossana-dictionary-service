package pl.hosannaponglish.dictionaryservice.dictionary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.LanguageCodeNotSupported;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryServiceFactory;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RestController
@RequestMapping("api/v1/dictionary/{code}")
@RequiredArgsConstructor
public class DictionaryController{

    private final DictionaryServiceFactory service;

    @GetMapping()
    public Page<Dictionary> getAll(@PathVariable LanguageCode code, Pageable pageable){
        return service.getService(code)
                .orElseThrow(() -> new LanguageCodeNotSupported())
                .getAll(pageable);
    }

    @GetMapping("/{id}")
    public Dictionary getOne(@PathVariable LanguageCode code, @PathVariable Long id){
        return service.getService(code)
                .orElseThrow(() -> new LanguageCodeNotSupported())
                .getOneById(id);
    }
}
