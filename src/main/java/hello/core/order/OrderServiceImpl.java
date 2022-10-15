package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
}
