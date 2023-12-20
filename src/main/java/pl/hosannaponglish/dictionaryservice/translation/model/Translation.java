package pl.hosannaponglish.dictionaryservice.translation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;
import pl.hosannaponglish.dictionaryservice.translation.code.enes.model.TranslationEnEs;
import pl.hosannaponglish.dictionaryservice.translation.code.enpl.model.TranslationEnPl;
import pl.hosannaponglish.dictionaryservice.translation.code.espl.model.TranslationEsPl;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TranslationEnPl.class, name = "TranslationEnPl"),
        @JsonSubTypes.Type(value = TranslationEnEs.class, name = "TranslationEnEs"),
        @JsonSubTypes.Type(value = TranslationEsPl.class, name = "TranslationEsPl")
})

public interface Translation{

    Long getId();

    void setId(Long id);

    Dictionary getExpressionSource();

    Dictionary getExpressionTarget();
}
