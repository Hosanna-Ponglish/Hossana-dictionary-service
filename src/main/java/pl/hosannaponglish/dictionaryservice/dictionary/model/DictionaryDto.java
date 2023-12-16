package pl.hosannaponglish.dictionaryservice.dictionary.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.category.model.Category;

import java.util.List;

/**
 * @author Bartosz Średziński
 * created on 22.10.2023
 */

@Getter
@Setter
public class DictionaryDto{

    @NotNull
    private String expression;

    @NotNull
    private List<Category> categories;
}
