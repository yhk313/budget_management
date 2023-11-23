package wanted.budgetmanagement.app.budgets.service;

import org.springframework.beans.factory.annotation.Autowired;
import wanted.budgetmanagement.app.budgets.domain.Budgets;
import wanted.budgetmanagement.app.budgets.exception.NotFoundException;
import wanted.budgetmanagement.app.budgets.repository.BudgetsRepository;
import wanted.budgetmanagement.app.category.domain.Category;
import wanted.budgetmanagement.app.category.repository.CategoryRepository;

import java.math.BigDecimal;

public class BudgetsServiceImpl implements BudgetsService{
    @Autowired
    private BudgetsRepository budgetsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Budgets setBudget(String category, BigDecimal amount) {
        Category findCategory = categoryRepository.findByName(category).orElseThrow(() -> new NotFoundException("Category not found" + category));
        Budgets budget = Budgets.builder()
            .category(findCategory)
            .amount(amount).build();
        return budgetsRepository.save(budget);
    }
}
