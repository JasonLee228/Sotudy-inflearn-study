package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO : 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자
 *        구현체에서 직접 선택하여 주입하는 것이 아닌, 별도 클래스에서 필요 객체를 주입해 주자
 *        애플리케이션의 실제 동작에 필요한 구현 객체를 생성자를 통해 주입한다
 *        AppConfig : 애플리케이션을 사용 영역과, 구성(Configuration)하는 영역으로 분리됨
 *        * 스프링에서의 DI 컨테이너 역할을 여기서 하고 있는 것.
 * */
/**
 * AppConfig 를 보면, 설계상의 역할과 구현이 어떻게 되어 있는지 명확하게 알 수 있다.
 * */

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        // 생성자를 통해 구현체 주입
        return new MemberServiceImpl(memberRepository());
    }

    // 중복의 제거를 위해서 개별 생성을 따로 뺐다.
    @Bean
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 정액 할인 정책에서 정률 할인 정책으로 변경 -> 단 한줄만 변경하면 돼!
                                         // 사용 영역을 변경하지 않고, 구성 영역의 변경만으로 정책 변경이 가능
    }

}
