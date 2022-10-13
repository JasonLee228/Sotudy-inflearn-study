package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // MemberServiceImpl 는 인터페이스인 MemberRepository 를 의존하고 있다. (추상화에 의존)
    // 그런데, 그 구현체인 MemoryMemberRepository 에도 의존하고 있음.(구체화에 의존)
    // 결론적으로, 변경에 취약함. -> DIP 위반

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
