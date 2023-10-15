package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.model.DictionaryEnPl;
import pl.hosannaponglish.dictionaryservice.dictionaryEnPl.service.DictionaryEnPlService;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RestController
@RequestMapping("api/v1/DictionaryEnPl/")
@RequiredArgsConstructor
public class DictionaryEnPlController{

    private final DictionaryEnPlService service;

    @GetMapping()
    public Page<DictionaryEnPl> getAll(Pageable pageable){
        return service.getAll(pageable);
    }
}
