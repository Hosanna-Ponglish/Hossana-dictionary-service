package pl.hosannaponglish.dictionaryservice.translation.code.espl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.language.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.language.pl.model.DictionaryPl;
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
public class TranslationEsPl implements Translation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private DictionaryEs expressionSource;

    @NotNull
    @ManyToOne
    private DictionaryPl expressionTarget;
}
