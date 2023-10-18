package pl.hosannaponglish.dictionaryservice.dictionary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Bartosz Średziński
 * created on 15.10.2023
 */
@Entity
@Table(name = "dictionary_en")
@Getter
@Setter
@NoArgsConstructor
public class Dictionary{
    @Id
    private Long dictionaryId;

    @NotNull
    private String translationEn;

    @NotNull
    private String translationPl;

    private String category;
}
