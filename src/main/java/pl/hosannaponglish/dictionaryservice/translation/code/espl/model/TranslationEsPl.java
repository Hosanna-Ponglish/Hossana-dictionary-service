package pl.hosannaponglish.dictionaryservice.translation.code.espl.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.es.model.DictionaryEs;
import pl.hosannaponglish.dictionaryservice.dictionary.pl.model.DictionaryPl;
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

    @ManyToOne
    private DictionaryEs expressionSource;

    @ManyToOne
    private DictionaryPl expressionTarget;
}
