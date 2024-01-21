package pl.hosannaponglish.dictionaryservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.hosannaponglish.dictionaryservice.dictionary.StringToLanguageCodeConverter;
import pl.hosannaponglish.dictionaryservice.translation.StringToTranslationCodeConverter;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToLanguageCodeConverter());
        registry.addConverter(new StringToTranslationCodeConverter());
    }
}
