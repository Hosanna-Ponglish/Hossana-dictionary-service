package pl.hosannaponglish.dictionaryservice.dictionary.service;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.en.service.DictionaryEnService;
import pl.hosannaponglish.dictionaryservice.dictionary.exception.LanguageCodeNotSupported;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.service.DictionaryPlService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author Bartosz Średziński
 * created on 07.11.2023
 */

@ExtendWith(MockitoExtension.class)
public class DictionaryServiceFactoryTest{

    private DictionaryServiceFactory dictionaryServiceFactory;

    @Mock
    private DictionaryPlService service1;
    @Mock
    private DictionaryEnService service2;


    @BeforeEach
    public void setUp(){
        dictionaryServiceFactory = new DictionaryServiceFactory(Lists.list(service1, service2));
    }

    @Test
    public void testGetServiceWhenServiceExists(){
        LanguageCode languageCode = LanguageCode.EN;
        when(service1.canHandle(languageCode)).thenReturn(false);
        when(service2.canHandle(languageCode)).thenReturn(true);

        DictionaryService result = dictionaryServiceFactory.getService(languageCode);

        assertEquals(service2, result);
    }

    @Test
    public void testGetServiceWhenNoServiceExists(){
        LanguageCode languageCode = LanguageCode.ES;
        when(service1.canHandle(languageCode)).thenReturn(false);
        when(service2.canHandle(languageCode)).thenReturn(false);

        assertThrows(LanguageCodeNotSupported.class, () -> dictionaryServiceFactory.getService(languageCode));
    }
}