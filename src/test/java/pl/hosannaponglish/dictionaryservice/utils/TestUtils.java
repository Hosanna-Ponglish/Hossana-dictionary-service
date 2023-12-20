package pl.hosannaponglish.dictionaryservice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Bartosz Średziński
 * created on 20.12.2023
 */

public class TestUtils{

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
