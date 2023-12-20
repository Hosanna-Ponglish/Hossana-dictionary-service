package pl.hosannaponglish.dictionaryservice.translation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
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
    public Page<Translation> getAll(@PathVariable TranslationCode code, Pageable pageable){
        return service.getService(code)
                .getAll(pageable);
    }

    @GetMapping("{id}")
    public Translation getOne(@PathVariable TranslationCode code, @PathVariable Long id){
        return service.getService(code)
                .getOneById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteOne(@PathVariable TranslationCode code, @PathVariable Long id){
        if(service.getService(code)
                .deleteById(id)){
            return ResponseEntity.ok()
                    .build();
        }

        return ResponseEntity.notFound()
                .build();
    }

    @PostMapping()
    public ResponseEntity<Translation> createOne(@PathVariable TranslationCode code, @RequestBody @Valid TranslationDto dto){
        Translation createdDictionary = service.getService(code)
                .addNewTranslationRecord(dto);

        if(createdDictionary != null){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(createdDictionary);
        }

        return ResponseEntity.badRequest()
                .build();
    }
}
