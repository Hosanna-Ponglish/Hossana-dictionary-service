package pl.hosannaponglish.dictionaryservice.dictionary.controller;

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
import org.springframework.test.web.servlet.MockMvc;
import pl.hosannaponglish.dictionaryservice.dictionary.LanguageCode;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.model.DictionaryPl;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.service.DictionaryPlService;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryServiceFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@SpringBootTest
@AutoConfigureMockMvc
class DictionaryControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DictionaryServiceFactory serviceFactory;

    @Mock
    private DictionaryPlService dictionaryPlService;

    @BeforeEach
    void setUp(){
        when(serviceFactory.getService(LanguageCode.PL)).thenReturn(Optional.of(dictionaryPlService));
    }

    @Test
    void testGetAll() throws Exception{
        Long id = 1L;
        DictionaryPl dictionary = new DictionaryPl();
        dictionary.setId(id);
        dictionary.setCategory("cat");
        dictionary.setExpression("exp");

        Pageable pageable = PageRequest.of(0, 10);
        Page<Dictionary> dummyPage = new PageImpl<>(List.of(dictionary));

        when(dictionaryPlService.getAll(pageable)).thenReturn(dummyPage);

        mockMvc.perform(get("/api/v1/dictionary/PL/")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.content", hasSize(1)));

        verify(dictionaryPlService, times(1)).getAll(pageable);
    }

    @Test
    void testGetOne() throws Exception{
        Long id = 1L;
        Dictionary dictionary = new DictionaryPl();
        dictionary.setId(id);

        when(dictionaryPlService.getOneById(id)).thenReturn(dictionary);

        mockMvc.perform(get("/api/v1/dictionary/PL/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id", is(id.intValue())));

        verify(dictionaryPlService, times(1)).getOneById(id);
    }
}