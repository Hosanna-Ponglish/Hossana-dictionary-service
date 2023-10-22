package pl.hosannaponglish.dictionaryservice.dictionary;


import org.springframework.core.convert.converter.Converter;

/**
 * Class description
 *
 * @author Bartosz Średziński
 * created on 22.10.2023
 */
public class StringToLanguageCodeConverter implements Converter<String, LanguageCode>{
    @Override
    public LanguageCode convert(String source) {
        return LanguageCode.valueOf(source.toUpperCase());
    }
}