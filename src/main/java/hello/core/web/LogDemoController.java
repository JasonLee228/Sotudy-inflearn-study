package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    /**
     * 스프링이 실행되지 않던 문제를 provider 를 통해 실제 요청이 들어온 시점에
     * provider.getObject() 를 통해 주입받을 수 있도록 했다.
     * 때문에 의존성이 필요할 때 주입될 수 있고, 오류 발생하지 않고 스프링이 실행될 수 있다.
     */

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        MyLogger myLogger = myLoggerProvider.getObject(); // 이 시점에 해당 request 에 대한 빈 생성 및 의존성 주입

        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}
