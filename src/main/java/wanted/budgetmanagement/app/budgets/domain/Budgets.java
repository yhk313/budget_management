package wanted.budgetmanagement.app.budgets.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.budgetmanagement.app.Member.domain.Member;
import wanted.budgetmanagement.app.category.domain.Category;

import java.math.BigDecimal;

@Entity
@Table(name = "budgets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Budgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
