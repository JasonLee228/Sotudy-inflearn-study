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
    private final MyLogger myLogger; // 중요! 실행 안되는 이유 아래.

    /**
     * 현재 코드 상태에서는 스프링은 뜰 수 없다.
     * MyLogger 클래스의 스코프는 request 이기 때문에
     * 요청이 들어오지 않으면 active 되지 않는데, 의존성 주입을 스프링 생성 시점에서 주입시키려고 하니 오류가 발생한다.
     * 요청이 들어오지 않아 생성되지 않은 없는 빈을 주입하려 해서.
     * -> 주입 시기를 요청이 왔을 때로 미뤄야 한다.!
     */

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}
