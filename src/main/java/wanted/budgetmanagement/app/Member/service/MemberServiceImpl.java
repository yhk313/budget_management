package wanted.budgetmanagement.app.Member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wanted.budgetmanagement.app.Member.domain.Member;
import wanted.budgetmanagement.app.Member.domain.MemberRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;



    /**
     *사용자를 생성하고 저장
     *@param username username
     *@return 생성된 사용자Id
     */
    @Override
    public Long createMember(String username) {
        Member member = Member.builder()
            .username(username).build();
        memberRepository.save(member);
        return member.getId();
    }
}
