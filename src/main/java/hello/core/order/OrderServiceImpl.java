package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); -> 변경!

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//     할인 정책의 변경 : 정액 -> 정률
//    * DIP: 주문서비스 클라이언트( OrderServiceImpl )는 DiscountPolicy 인터페이스에 의존하면서 DIP 를 지킨 것 같은데?
//    클래스 의존관계를 분석해 보자. 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다.
//        추상(인터페이스) 의존: DiscountPolicy
//        구체(구현) 클래스: FixDiscountPolicy , RateDiscountPolicy
//    * OCP: 변경하지 않고 확장할 수 있다고 했는데!
//        지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! 따라서 OCP 를 위반한다.
//    해결 : DIP, OCP 를 위반하지 않도록 , 인터페이스에만 의존하도록 의존관계를 변경하면 된다
//    -> 구체 선언 부분 자체를 보이지 않게 하면 된다! : 누군가 클라이언트에 구현 객체를 대신 생성 후 주입해주어야 한다.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); // 주문 대상 회원 조회

        /*
        * OrderService 는 할인 정책에 대해서 알 수 없음. DiscountPolicy 에게 모든 할인 정책 이양
        * 단일 책임 원칙을 잘 지킨 것이라고 할 수 있다(할인에 관련된 부분을 수정하게 될 때애 discountPolicy 만 수정하면 되기 때문에)
        */
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 금액

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 생성된 주문 반환
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
