package pl.hosannaponglish.dictionaryservice.dictionaryEnPl.model;

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
@Table(name = "dictionary_en_pl")
@Getter
@Setter
@NoArgsConstructor
public class DictionaryEnPl{
    @Id
    private Long dictionary_en_pl_id;

    @NotNull
    private String translation_en;

    @NotNull
    private String translation_pl;

    private String category;
}
