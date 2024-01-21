package pl.hosannaponglish.dictionaryservice.translation.code.enes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.language.en.model.DictionaryEn;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;

/**
 * @author Bartosz Średziński
 * created on 17.12.2023
 */

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class TranslationEnEs implements Translation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private DictionaryEn expressionSource;

    @NotNull
    @ManyToOne
    private DictionaryEs expressionTarget;
}
