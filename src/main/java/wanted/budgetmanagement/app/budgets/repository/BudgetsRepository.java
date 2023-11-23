package wanted.budgetmanagement.app.budgets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wanted.budgetmanagement.app.budgets.domain.Budgets;

@Repository
public interface BudgetsRepository extends JpaRepository<Budgets, Long> {
}
