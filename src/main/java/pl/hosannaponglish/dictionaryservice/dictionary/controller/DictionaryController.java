package pl.hosannaponglish.dictionaryservice.dictionary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.LanguageCodeNotSupported;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryServiceFactory;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RestController
@RequestMapping("api/v1/dictionary/{code}/")
@RequiredArgsConstructor
public class DictionaryController{

    private final DictionaryServiceFactory service;

    @GetMapping()
    @ResponseBody
    public Page<Dictionary> getAll(@PathVariable LanguageCode code, Pageable pageable){
        return service.getService(code)
                .orElseThrow(LanguageCodeNotSupported::new)
                .getAll(pageable);
    }

    @GetMapping("{id}")
    public Dictionary getOne(@PathVariable LanguageCode code, @PathVariable Long id){
        return service.getService(code)
                .orElseThrow(LanguageCodeNotSupported::new)
                .getOneById(id);
    }
}
