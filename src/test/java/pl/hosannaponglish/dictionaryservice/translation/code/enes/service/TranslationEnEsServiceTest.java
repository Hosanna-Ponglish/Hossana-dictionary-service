package pl.hosannaponglish.dictionaryservice.translation.code.enes.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.model.TranslationEnEs;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.repository.TranslationEnEsRepository;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationNotFoundException;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

class TranslationEnEsServiceTest{

    @Mock
    private TranslationEnEsRepository repository;

    private TranslationEnEsService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new TranslationEnEsService(repository);
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
        TranslationEnEs translationEnEs = new TranslationEnEs();
        translationEnEs.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(translationEnEs));

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
        assertTrue(service.canHandle(TranslationCode.ENES));
        assertFalse(service.canHandle(TranslationCode.ENPL));
    }

    @Test
    void testAddNewTranslationRecord(){
        TranslationEnEs newTranslationEnEs = new TranslationEnEs();

        TranslationDto dto = new TranslationDto();
        DictionaryEn dictionaryEn = new DictionaryEn();
        dictionaryEn.setId(1L);
        dictionaryEn.setExpression("expressionEn");

        DictionaryEs dictionaryEs = new DictionaryEs();
        dictionaryEs.setId(1L);
        dictionaryEs.setExpression("expressionEs");

        dto.setExpressionSource(dictionaryEn);
        dto.setExpressionTarget(dictionaryEs);

        newTranslationEnEs.setExpressionSource(dictionaryEn);
        newTranslationEnEs.setExpressionTarget(dictionaryEs);

        when(repository.save(any(TranslationEnEs.class))).thenReturn(newTranslationEnEs);

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

}