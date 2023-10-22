package pl.hosannaponglish.dictionaryservice.dictionary.es.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.es.repository.DictionaryEsRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Class description
 *
 * @author Bartosz Średziński
 * created on 22.10.2023
 */
class DictionaryEsServiceTest{

    @Mock
    private DictionaryEsRepository repository;

    private DictionaryEsService dictionaryService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        dictionaryService = new DictionaryEsService(repository);
    }

    @Test
    void testGetAll(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Dictionary> dummyPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        when(repository.getAll(pageable)).thenReturn(dummyPage);

        Page<Dictionary> result = dictionaryService.getAll(pageable);

        verify(repository, times(1)).getAll(pageable);
        assertEquals(dummyPage, result);
    }

    @Test
    void testGetOneById(){
        Long id = 1L;
        DictionaryEs dictionary = new DictionaryEs();
        dictionary.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(dictionary));

        Dictionary result = dictionaryService.getOneById(id);

        verify(repository, times(1)).findById(id);
        assertEquals(id, result.getId());
    }

    @Test
    void testGetOneByIdNotFound(){
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(DictionaryNotFoundException.class, () -> dictionaryService.getOneById(id));

        verify(repository, times(1)).findById(id);
    }

    @Test
    void testCanHandle(){
        assertTrue(dictionaryService.canHandle(LanguageCode.ES));
        assertFalse(dictionaryService.canHandle(LanguageCode.EN));
    }
}