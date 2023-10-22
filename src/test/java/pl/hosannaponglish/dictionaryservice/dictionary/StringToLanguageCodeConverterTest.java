package pl.hosannaponglish.dictionaryservice.dictionary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */
class StringToLanguageCodeConverterTest{

    private final StringToLanguageCodeConverter converter = new StringToLanguageCodeConverter();

    @Test
    public void testConvertValidValue() {
        String validValue = "PL";
        LanguageCode result = converter.convert(validValue);
        assertEquals(LanguageCode.PL, result);
    }

    @Test
    public void testConvertValidValueWithLowerCase() {
        String validValue = "en";
        LanguageCode result = converter.convert(validValue);
        assertEquals(LanguageCode.EN, result);
    }

    @Test
    public void testConvertInvalidValue() {
        String invalidValue = "InvalidCode";

        assertThrows(IllegalArgumentException.class, () -> converter.convert(invalidValue));
    }
}