package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 구현체를 생성자를 통해서 주입해준다 -> 클라이언트 클래스(MemberServiceImpl) 는 인터페이스만 의존할 수 있게 해준다.(DIP 준수, 관심사의 분리)

    // 컴포넌트 스캔을 통해 빈 등록 시 @Autowired 를 사용하여 자동 빈 주입을 할 수 있다.
    // 이는 applicationContext.getBean(MemberRepository.class) 와 비슷하게 이해하면 된다.
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
