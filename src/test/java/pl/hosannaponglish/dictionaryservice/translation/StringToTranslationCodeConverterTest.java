package pl.hosannaponglish.dictionaryservice.translation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Bartosz Średziński
 * created on 18.12.2023
 */

class StringToTranslationCodeConverterTest{

    private final StringToTranslationCodeConverter converter = new StringToTranslationCodeConverter();

    @Test
    void testConvertValidValue(){
        String validValue = "ENPL";
        TranslationCode result = converter.convert(validValue);
        assertEquals(TranslationCode.ENPL, result);
    }

    @Test
    void testConvertValidValueWithLowerCase(){
        String validValue = "enes";
        TranslationCode result = converter.convert(validValue);
        assertEquals(TranslationCode.ENES, result);
    }

    @Test
    void testConvertInvalidValue(){
        String invalidValue = "InvalidCode";

        assertThrows(IllegalArgumentException.class, () -> converter.convert(invalidValue));
    }
}