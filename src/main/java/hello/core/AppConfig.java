package hello.core;

import hello.core.discount.FixDiscountPolicy;
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
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
