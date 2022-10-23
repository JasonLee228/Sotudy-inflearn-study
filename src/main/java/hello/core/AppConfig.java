package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * TODO : 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스를 만들자
 *        구현체에서 직접 선택하여 주입하는 것이 아닌, 별도 클래스에서 필요 객체를 주입해 주자
 *        애플리케이션의 실제 동작에 필요한 구현 객체를 생성자를 통해 주입한다
 * */
public class AppConfig {

    public MemberService memberService() {
        // 생성자를 통해 구현체 주입
        return new MemberServiceImpl(memberRepository());
    }

    // 중복의 제거를 위해서 개별 생성을 따로 뺐다.
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();

    }

    /**
     * AppConfig 를 보면, 설계상의 역할과 구현이 어떻게 되어 있는지 명확하게 알 수 있다.
     * */

}
