package pl.hosannaponglish.dictionaryservice.translation.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.translation.TranslationCode;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.model.TranslationEnPl;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.service.TranslationEnPlService;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;
import pl.hosannaponglish.dictionaryservice.translation.model.TranslationDto;
import pl.hosannaponglish.dictionaryservice.translation.service.TranslationServiceFactory;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static pl.hosannaponglish.dictionaryservice.utils.TestUtils.asJsonString;

/**
 * @author Bartosz Średziński
 * created on 19.12.2023
 */

@SpringBootTest
@AutoConfigureMockMvc
class TranslationControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TranslationServiceFactory serviceFactory;

    @Mock
    private TranslationEnPlService translationEnPlService;

    @BeforeEach
    void setUp(){
        when(serviceFactory.getService(TranslationCode.ENPL)).thenReturn(translationEnPlService);
    }

    @Test
    void testGetAll() throws Exception{
        Long id = 1L;

        DictionaryEn dictionaryEn = new DictionaryEn();
        dictionaryEn.setId(id);
        dictionaryEn.setExpression("expressionEn");

        DictionaryPl dictionaryPl = new DictionaryPl();
        dictionaryPl.setId(id);
        dictionaryPl.setExpression("expressionPl");

        TranslationEnPl translation = new TranslationEnPl();
        translation.setId(id);
        translation.setExpressionSource(dictionaryEn);
        translation.setExpressionTarget(dictionaryPl);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Translation> dummyPage = new PageImpl<>(List.of(translation));

        when(translationEnPlService.getAll(pageable)).thenReturn(dummyPage);

        mockMvc.perform(get("/api/v1/translation/ENPL/").param("page", "0")
                        .param("size", "10")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.content", hasSize(1)));

        verify(translationEnPlService, times(1)).getAll(pageable);
    }

    @Test
    void testGetOne() throws Exception{
        Long id = 1L;

        DictionaryEn dictionaryEn = new DictionaryEn();
        dictionaryEn.setId(id);
        dictionaryEn.setExpression("expressionEn");

        DictionaryPl dictionaryPl = new DictionaryPl();
        dictionaryPl.setId(id);
        dictionaryPl.setExpression("expressionPl");

        TranslationEnPl translation = new TranslationEnPl();
        translation.setId(id);
        translation.setExpressionSource(dictionaryEn);
        translation.setExpressionTarget(dictionaryPl);

        when(translationEnPlService.getOneById(id)).thenReturn(translation);

        mockMvc.perform(get("/api/v1/translation/ENPL/" + id).contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        verify(translationEnPlService, times(1)).getOneById(id);
    }

    @Test
    void testDeleteOneSuccess() throws Exception{
        Long id = 1L;
        TranslationCode code = TranslationCode.ENPL;

        when(serviceFactory.getService(code)).thenReturn(translationEnPlService);
        when(translationEnPlService.deleteById(id)).thenReturn(true);

        mockMvc.perform(delete("/api/v1/translation/ENPL/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteOneNotFound() throws Exception{
        Long id = 1L;
        TranslationCode code = TranslationCode.ENPL;

        when(serviceFactory.getService(code)).thenReturn(translationEnPlService);
        when(translationEnPlService.deleteById(id)).thenReturn(false);

        mockMvc.perform(delete("/api/v1/translation/ENPL/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateOneSuccess() throws Exception{
        Long id = 1L;

        DictionaryEn dictionaryEn = new DictionaryEn();
        dictionaryEn.setId(id);
        dictionaryEn.setExpression("expressionEn");

        DictionaryPl dictionaryPl = new DictionaryPl();
        dictionaryPl.setId(id);
        dictionaryPl.setExpression("expressionPl");

        TranslationCode code = TranslationCode.ENPL;
        TranslationDto dto = new TranslationDto();
        dto.setExpressionSource(dictionaryEn);
        dto.setExpressionTarget(dictionaryPl);

        when(serviceFactory.getService(code)).thenReturn(translationEnPlService);

        Translation createdTranslation = new TranslationEnPl();
        createdTranslation.setId(1L);
        when(translationEnPlService.addNewTranslationRecord(any(TranslationDto.class))).thenReturn(createdTranslation);

        mockMvc.perform(post("/api/v1/translation/ENPL/").content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id")
                        .exists());
    }

    @Test
    void testCreateOneBadRequest() throws Exception{
        TranslationCode code = TranslationCode.ENPL;
        TranslationDto dto = new TranslationDto();

        when(serviceFactory.getService(code)).thenReturn(translationEnPlService);

        Translation createdTranslation = new TranslationEnPl();
        createdTranslation.setId(1L);
        when(translationEnPlService.addNewTranslationRecord(any(TranslationDto.class))).thenReturn(null);

        mockMvc.perform(post("/api/v1/translation/ENPL/").content(asJsonString(dto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}