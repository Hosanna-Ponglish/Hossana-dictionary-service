package pl.hosannaponglish.dictionaryservice.dictionary.model;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */
public interface Dictionary{

    Long getId();

    void setId(Long id);

    String getExpression();

    void setExpression(String expression);

    String getCategory();

    void setCategory(String category);
}
