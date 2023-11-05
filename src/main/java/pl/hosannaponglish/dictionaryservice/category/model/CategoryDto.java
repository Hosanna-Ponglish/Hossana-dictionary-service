package pl.hosannaponglish.dictionaryservice.category.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@Getter
@Setter
public class CategoryDto{
    @NotNull
    private String symbol;
}
