package pl.hosannaponglish.dictionaryservice.translation;

import org.springframework.core.convert.converter.Converter;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public class StringToTranslationCodeConverter implements Converter<String, TranslationCode>{

    @Override
    public TranslationCode convert(String source){
        return TranslationCode.valueOf(source.toUpperCase());
    }
}
