package wanted.budgetmanagement.app.budgets.service;

import wanted.budgetmanagement.app.budgets.domain.Budgets;

import java.math.BigDecimal;

public interface BudgetsService {
    Budgets setBudget(String category, BigDecimal amount);

}
