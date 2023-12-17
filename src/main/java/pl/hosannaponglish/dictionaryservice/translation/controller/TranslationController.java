package pl.hosannaponglish.dictionaryservice.translation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationServiceFactory;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@RestController
@RequestMapping("api/v1/translation/{code}/")
@RequiredArgsConstructor
public class TranslationController{

    private final TranslationServiceFactory service;

    @GetMapping()
    @ResponseBody
    public Page<Translation> getAll(@PathVariable TranslationCode code, Pageable pageable){
        return service.getService(code)
                .getAll(pageable);
    }

    @GetMapping("{id}")
    public Translation getOne(@PathVariable TranslationCode code, @PathVariable Long id){
        return service.getService(code)
                .getOneById(id);
    }
}
