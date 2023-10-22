package pl.hosannaponglish.dictionaryservice.dictionary.en.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class DictionaryEn implements Dictionary{

    @Id
    private Long dictionaryId;

    @NotNull
    private String expression;

    @NotNull
    private String targetTranslation;

    private String category;
}
