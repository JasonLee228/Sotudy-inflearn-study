package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl(); // 사용에도 더이상 객체 생성을 할 필요 없음.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();// -> appconfig를 통해서 전달받음

        // 스프링에서 빈을 등록하고 관리하는 방법. AnnotationConfigApplicationContext 클래스에서는 AppConfig 라는 구성 파일에 @Bean 이 붙은 클래스 구현 메소드들을 빈으로 등록.
        // 빈 등록 이름은 AppConfig 의 메소드 이름으로 등록됨.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // memberService 라는 빈 이름의 MemberService 라는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

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
