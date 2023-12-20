package pl.hosannaponglish.dictionaryservice.translation.service;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.service.TranslationEnEsService;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.service.TranslationEnPlService;
import pl.hosannaponglish.dictionaryservice.translation.exception.TranslationCodeNotSupported;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Bartosz Średziński
 * created on 18.12.2023
 */

@ExtendWith(MockitoExtension.class)
class TranslationServiceFactoryTest{

    @Mock
    private TranslationEnPlService translationEnPlService;

    @Mock
    private TranslationEnEsService translationEnEsService;

    private TranslationServiceFactory factory;

    @BeforeEach
    void setUp(){
        factory = new TranslationServiceFactory(Lists.list(translationEnPlService, translationEnEsService));
    }

    @Test
    void testGetServiceForEnPl(){
        when(translationEnPlService.canHandle(TranslationCode.ENPL)).thenReturn(true);

        TranslationService result = factory.getService(TranslationCode.ENPL);
        assertTrue(result instanceof TranslationEnPlService);
    }

    @Test
    void testGetServiceForEnEs(){
        when(translationEnEsService.canHandle(TranslationCode.ENES)).thenReturn(true);

        TranslationService result = factory.getService(TranslationCode.ENES);
        assertTrue(result instanceof TranslationEnEsService);
    }

    @Test
    void testGetServiceWhenNoServiceExists(){
        TranslationCode translationCode = TranslationCode.ENES;
        when(translationEnPlService.canHandle(translationCode)).thenReturn(false);
        when(translationEnEsService.canHandle(translationCode)).thenReturn(false);

        assertThrows(TranslationCodeNotSupported.class, () -> factory.getService(translationCode));
    }

}