package pl.hosannaponglish.dictionaryservice.dictionary.es.service;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.es.repository.DictionaryEsRepository;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.DictionaryNotFoundException;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.model.DictionaryDto;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void testAddNewDictionaryRecord(){
        DictionaryDto dto = new DictionaryDto();
        dto.setExpression("Test Expression");
        dto.setCategories(Lists.list(new Category()));

        DictionaryEs newDictionary = new DictionaryEs();
        newDictionary.setExpression(dto.getExpression());
        newDictionary.setCategories(Lists.list(new Category()));

        when(repository.save(any(DictionaryEs.class))).thenReturn(newDictionary);

        Dictionary result = dictionaryService.addNewDictionaryRecord(dto);

        assertNotNull(result);
        assertEquals(dto.getExpression(), result.getExpression());
        assertThat(dto.getCategories()).hasSize(1);
    }

    @Test
    void testDeleteByIdSuccess(){
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        boolean result = dictionaryService.deleteById(id);

        assertTrue(result);
        verify(repository).deleteById(id);
    }

    @Test
    void testDeleteByIdFail(){
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(false);

        boolean result = dictionaryService.deleteById(id);

        assertFalse(result);
        verify(repository, never()).deleteById(id);
    }
}