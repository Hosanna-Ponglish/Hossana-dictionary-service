package pl.hosannaponglish.dictionaryservice.dictionary.es.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

/**
 * @author Bartosz Średziński
 * created on 21.10.2023
 */

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class DictionaryEs implements Dictionary{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String expression;

    private String category;
}
