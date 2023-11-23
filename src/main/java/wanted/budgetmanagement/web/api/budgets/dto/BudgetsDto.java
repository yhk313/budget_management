package wanted.budgetmanagement.web.api.budgets.dto;

import wanted.budgetmanagement.app.budgets.domain.Budgets;

import java.math.BigDecimal;

public record BudgetsDto(Long id, String category, BigDecimal amount) {

    public static BudgetsDto fromBudget(Budgets budget) {
        String categoryName = budget.getCategory() != null ? budget.getCategory().getName() : null;
        return new BudgetsDto(budget.getId(), categoryName, budget.getAmount());
    }
}

