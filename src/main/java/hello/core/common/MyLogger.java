package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    /**
     * 스프링에 HTTP 요청이 들어오게 되면 요청 당 빈이 하나씩 생성되고, 요청 끝나는 시점에 소멸
     */

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {

        System.out.println("[" + uuid + "] " + "[" + requestURL + "] " + message);

    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] " + "request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] " + "request scope bean close : " + this);
    }
}
