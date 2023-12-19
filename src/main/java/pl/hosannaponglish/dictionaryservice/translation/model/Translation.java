package pl.hosannaponglish.dictionaryservice.translation.model;

import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

public interface Translation{

    Long getId();

    void setId(Long id);

    Dictionary getExpressionSource();

    Dictionary getExpressionTarget();
}
