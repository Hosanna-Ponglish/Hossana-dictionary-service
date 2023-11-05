package pl.hosannaponglish.dictionaryservice.dictionary.model;

import pl.hosannaponglish.dictionaryservice.category.model.Category;

import java.util.List;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */
public interface Dictionary{

    Long getId();

    void setId(Long id);

    String getExpression();

    void setExpression(String expression);

    List<Category> getCategories();

    void setCategories(List<Category> categories);
}
