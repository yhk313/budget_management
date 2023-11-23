package wanted.budgetmanagement.web.api.budgets.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wanted.budgetmanagement.app.budgets.domain.Budgets;
import wanted.budgetmanagement.app.budgets.service.BudgetsService;
import wanted.budgetmanagement.web.api.budgets.dto.BudgetsDto;

import java.math.BigDecimal;
@RestController
@RequestMapping("/api/budgets")
public class BudgetsController {
    @Autowired
    private BudgetsService budgetsService;

    @PostMapping("/set")
    public ResponseEntity<BudgetsDto> setBudget(@RequestParam("category") String categoryName,
                                                @RequestParam("amount") BigDecimal amount) {
        Budgets budget = budgetsService.setBudget(categoryName, amount);

        BudgetsDto budgetDTO = BudgetsDto.fromBudget(budget);

        return new ResponseEntity<>(budgetDTO, HttpStatus.OK);
    }

}
