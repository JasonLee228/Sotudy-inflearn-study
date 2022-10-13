package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    /*
    TODO: MemberApp 에서 수행하던 애플리케이션 정상 동작 여부를 Test 를 통해서 확인할 수 있다.
    */
    @Test
    void join() {

        // given
        Member member = new Member(1L, "changeun", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}
