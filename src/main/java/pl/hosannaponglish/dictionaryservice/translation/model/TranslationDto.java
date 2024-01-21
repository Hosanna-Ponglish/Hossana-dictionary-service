package pl.hosannaponglish.dictionaryservice.translation.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Setter
@Getter
public class TranslationDto{

    @NotNull
    private Dictionary expressionSource;

    @NotNull
    private Dictionary expressionTarget;
}
