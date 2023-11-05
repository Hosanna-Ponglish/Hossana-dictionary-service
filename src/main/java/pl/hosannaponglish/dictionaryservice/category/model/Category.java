package pl.hosannaponglish.dictionaryservice.category.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String symbol;
}
