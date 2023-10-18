package pl.hosannaponglish.dictionaryservice.dictionary.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryService;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */

@RestController
@RequestMapping("api/v1/dictionary/")
@RequiredArgsConstructor
public class DictionaryController{

    private final DictionaryService service;

    @GetMapping()
    public Page<Dictionary> getAll(Pageable pageable){
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Dictionary getOne(@PathVariable Long id){
        return service.getOneById(id);
    }

    @GetMapping("/search")
    public Dictionary simpleFind(@PathParam("data") String data){
        return service.simpleFind(data);
    }
}
