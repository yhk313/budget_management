package wanted.budgetmanagement.app.Member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wanted.budgetmanagement.app.budgets.domain.Budgets;

import java.util.List;


@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @OneToMany(mappedBy = "member")
    private List<Budgets> budgets;


    @Builder
    public Member(String username) {
        this.username = username;
    }
}
