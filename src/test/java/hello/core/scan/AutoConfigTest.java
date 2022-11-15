package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoConfigTest {

    @Test
    void basicScan() {

        // AutoAppConfig 에는 별도로 설정정보를 만들지 않았지만 컴포넌트 스캔을 통해 빈 등록 및 주입이 잘 이루어짐을 알 수 있다
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }



}
