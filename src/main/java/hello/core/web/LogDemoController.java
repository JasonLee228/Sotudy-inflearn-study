package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    /**
     * 코드상으로 보면 기존의 오류로 동작하지 않았던 것과 같아 보이지만,
     * MyLogger 클래스에 ProxyMode 를 설정하게 되면서 정상적으로 실행되는 것을 볼 수 있다.
     *
     * 아래 soutv를 통해 myLogger 클래스를 직접 확인하면 알 수 있지만,
     * 프록시모드를 사용하게 되면 MyLogger 클래스의 실제 기능을 동작시키기 전에는
     * CGLIB 을 통해 MyLogger 의 가짜 프록시 클래스를 생성하고, request 가 들어오기 전에는
     * 가짜 코드를 통해 의존성을 주입하여 의존성 주입의 문제를 해결하는 것이다.
     *
     * 프록시 객체에는 실제 객체를 찾아주는 로직이 들어 있고,
     * 클라이언트가 myLogger.logic 을 호출하면 그것은 프록시 객체의 logic() 을 호출하는 것이다.
     * 가짜 프록시 객체는 request 스코프의 원래 메소드를 호출한다.
     */

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        System.out.println("myLogger = " + myLogger.getClass());

        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}
