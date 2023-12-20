package pl.hosannaponglish.dictionaryservice.translation.specification;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.hosannaponglish.dictionaryservice.translation.model.Translation;

/**
 * @author Bartosz Średziński
 * created on 20.12.2023
 */

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TranslationSpecification{

    public static Specification<Translation> hasExpressionSourceOrExpressionTargetLike(String expression){
        return (root, query, builder) -> builder.or(builder.like(root.get("expressionSource")
                .get("expression"), "%" + expression + "%"), builder.like(root.get("expressionTarget")
                .get("expression"), "%" + expression + "%"));
    }
}
