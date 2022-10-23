package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl(); // 사용에도 더이상 객체 생성을 할 필요 없음.
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();// -> appconfig를 통해서 전달받음

        Member member = new Member(1L, "changeun", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("Member = " + member.getName());


        /*
        * 순수 자바 코드로 애플리케이션 테스트
        */
    }

}
