package pl.hosannaponglish.dictionaryservice.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;

import java.util.List;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DictionaryPl.class, name = "dictionaryPl"),
        @JsonSubTypes.Type(value = DictionaryEn.class, name = "dictionaryEn"),
        @JsonSubTypes.Type(value = DictionaryEs.class, name = "dictionaryEn")
})
public interface Dictionary{

    Long getId();

    void setId(Long id);

    String getExpression();

    void setExpression(String expression);

    List<Category> getCategories();

    void setCategories(List<Category> categories);
}
