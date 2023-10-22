package pl.hosannaponglish.dictionaryservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hosannaponglish.dictionaryservice.dictionary.service.DictionaryServiceFactory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DictionaryEnServiceApplicationTests{

    @Autowired
    private DictionaryServiceFactory service;

    @Test
    void contextLoads(){
        assertThat(service).isNotNull();
    }

}
