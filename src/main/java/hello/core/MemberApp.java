package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig버전
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //순수 java버전
        //MemberService memberService = new MemberServiceImpl();

        //스프링 버전
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // Appconfig에 있는 환경설정 정보를 가지고 @Bean붙은 값들을 스프링컨테이너에 집어 넣어서 관리해준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // bean에는 메서드 이름으로 등록됨으로 이름으로 찾아야 한다. (찾는 이름, 반환타입)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new memeber ="+member.getName());
        System.out.println("find Member ="+findMember.getName());

    }
}
