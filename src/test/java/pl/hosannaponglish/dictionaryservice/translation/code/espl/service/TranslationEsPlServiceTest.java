package pl.hosannaponglish.dictionaryservice.translation.code.espl.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.repository.TranslationEsPlRepository;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 18.12.2023
 */

class TranslationEsPlServiceTest{

    @Mock
    private TranslationEsPlRepository repository;

    private TranslationEsPlService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new TranslationEsPlService(repository);
    }

    @Test
    void testGetAll(){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Translation> dummyPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        when(repository.getAll(pageable)).thenReturn(dummyPage);

        Page<Translation> result = service.getAll(pageable);

        verify(repository, times(1)).getAll(pageable);
        assertEquals(dummyPage, result);
    }

    @Test
    void testGetOneById(){
        Long id = 1L;
        TranslationEsPl translationEsPl = new TranslationEsPl();
        translationEsPl.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(translationEsPl));

        Translation result = service.getOneById(id);

        verify(repository, times(1)).findById(id);
        assertEquals(id, result.getId());
    }

    @Test
    void testGetOneByIdNotFound(){
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TranslationNotFoundException.class, () -> service.getOneById(id));

        verify(repository, times(1)).findById(id);
    }

    @Test
    void testCanHandle(){
        assertTrue(service.canHandle(TranslationCode.ESPL));
        assertFalse(service.canHandle(TranslationCode.ENES));
    }

    @Test
    void testAddNewTranslationRecord(){
        TranslationEsPl newTranslationEsPl = new TranslationEsPl();

        TranslationDto dto = new TranslationDto();
        DictionaryEs dictionaryEs = new DictionaryEs();
        dictionaryEs.setId(1L);
        dictionaryEs.setExpression("expressionEs");

        DictionaryPl dictionaryPl = new DictionaryPl();
        dictionaryPl.setId(1L);
        dictionaryPl.setExpression("expressionPl");

        dto.setExpressionSource(dictionaryEs);
        dto.setExpressionTarget(dictionaryPl);

        newTranslationEsPl.setExpressionSource(dictionaryEs);
        newTranslationEsPl.setExpressionTarget(dictionaryPl);

        when(repository.save(any(TranslationEsPl.class))).thenReturn(newTranslationEsPl);

        Translation result = service.addNewTranslationRecord(dto);

        assertNotNull(result);
        assertEquals(dto.getExpressionSource(), result.getExpressionSource());
        assertEquals(dto.getExpressionTarget(), result.getExpressionTarget());
        verify(repository, times(1)).save(any());
    }

    @Test
    void testDeleteById(){
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        boolean result = service.deleteById(id);

        assertTrue(result);
        verify(repository, times(1)).existsById(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteByIdNotFound(){
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(false);

        boolean result = service.deleteById(id);

        assertFalse(result);
        verify(repository, times(1)).existsById(id);
        verify(repository, times(0)).deleteById(id);
    }

    @Test
    void testSearch(){
        String expression = "expression";
        Pageable pageable = PageRequest.of(0, 10);
        Page<Translation> dummyPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        when(repository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(dummyPage);

        Page<Translation> result = service.search(expression, pageable);

        verify(repository, times(1)).findAll(any(Specification.class), any(Pageable.class));
        assertEquals(dummyPage, result);
    }
}