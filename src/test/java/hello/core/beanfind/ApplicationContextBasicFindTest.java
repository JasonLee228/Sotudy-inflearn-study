package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {

        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {

        // MemberService 인터페이스가 아닌 그 구현체 MemberServiceImpl 로 조회할 수 있다.
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // 급 궁금. 실제 빈이 등록되는 거는 구현체 객체로 등록되는데 왜 인터페이스로도 검색이 되나?
        // AppConfig 에서 반환 타입을 인터페이스로 했지만, 실제 등록은 인스턴스 타입으로 빈을 결정하기 때문에 된다,,?
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameX() {

        // MemberServiceImpl xxxxx = ac.getBean("xxxxx", MemberServiceImpl.class);
        // 결과: NoSuchBeanDefinitionException: No bean named 'xxxxx' available

        // assertThrows : 해당 로직에서 해당 예외가 나와야 테스트 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberServiceImpl.class));

    }
}
