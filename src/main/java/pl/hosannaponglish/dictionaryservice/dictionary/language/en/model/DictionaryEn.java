package pl.hosannaponglish.dictionaryservice.dictionary.language.en.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hosannaponglish.dictionaryservice.category.model.Category;
import pl.hosannaponglish.dictionaryservice.dictionary.model.Dictionary;

import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String expression;

    @ManyToMany
    private List<Category> categories;
}
