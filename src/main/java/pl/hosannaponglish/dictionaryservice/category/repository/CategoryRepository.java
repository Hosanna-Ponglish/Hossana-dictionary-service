package pl.hosannaponglish.dictionaryservice.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hosannaponglish.dictionaryservice.category.model.Category;

/**
 * @author Bartosz Średziński
 * created on 05.11.2023
 */

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
