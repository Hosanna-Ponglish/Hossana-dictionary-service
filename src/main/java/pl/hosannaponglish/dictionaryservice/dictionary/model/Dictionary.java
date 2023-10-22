package pl.hosannaponglish.dictionaryservice.dictionary.model;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */
public interface Dictionary{

    public Long getDictionaryId();

    public String getExpression();

    public String getCategory();
}
