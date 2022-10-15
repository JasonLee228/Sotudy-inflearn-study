package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class fixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000 원 할인 고정 금액

    @Override
    public int discount(Member member, int price) {

        // enum 타입은 비교 시 equal 이 아닌 == 쓰는게 맞다.
        if(member.getGrade() == Grade.VIP) {

            return discountFixAmount;

        } else {

            return 0;

        }

    }
}
