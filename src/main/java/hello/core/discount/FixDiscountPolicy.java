package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000 원 할인 고정 금액

    @Override
    public int discount(Member member, int price) {

        // enum 타입은 비교 시 equal 이 아닌 == 쓰는게 맞다.
        if(member.getGrade() == Grade.VIP) {
            // Grade 가 VIP 일 경우, 고정 금액 (1000원) 할인
            return discountFixAmount;

        } else {
            // VIP 가 아닐 경우 할인 없음
            return 0;

        }

    }
}
