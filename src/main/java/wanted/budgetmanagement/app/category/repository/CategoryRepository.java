package wanted.budgetmanagement.app.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.budgetmanagement.app.category.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
